package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HbmTrackerTest {

    private final HbmTracker tracker = new HbmTracker();
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @AfterEach
    public void clearTable() {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Item");
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (tracker) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemSuccessfullyThenReturnTrue() {
        try (tracker) {
            Item item1 = new Item();
            item1.setName("test1");
            tracker.add(item1);
            Item item2 = new Item();
            item2.setName("test2");
            assertThat(tracker.replace(item1.getId(), item2)).isTrue();
        }
    }

    @Test
    public void whenDeleteItemSuccessfullyThenReturnTrue() {
        try (tracker) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            assertThat(tracker.delete(item.getId())).isTrue();
        }
    }

    @Test
    public void whenAdd5ItemsThenItemsListSizeIs5() {
        try (tracker) {
            Item item = new Item();
            for (int i = 1; i <= 5; i++) {
                item.setName("test" + i);
                tracker.add(item);
            }
            assertThat(tracker.findAll()).size().isEqualTo(5);
        }
    }

    @Test
    public void whenAddItemThenFindByNameReturnItem() {
        try (tracker) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            List<Item> byName = tracker.findByName(item.getName());
            assertThat(byName).contains(item);
        }
    }

    @Test
    public void whenAddItemThenFindByIdReturnItem() {
        try (tracker) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result).isEqualTo(item);
        }
    }
}