package ru.job4j.tracker;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class DateRun {

    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf
                    .withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("Africa/Addis_Ababa"))
                    .openSession();
            session.beginTransaction();
            var item = new Item();
            item.setName("check timezone1");
            item.setCreated(LocalDateTime.now());
            session.persist(item);
            var stored = session.createQuery(
                    "from Item", Item.class
            ).list();
            for (Item it : stored) {
                var time = it.getCreated().atZone(ZoneId.of("Africa/Addis_Ababa"));
                ZonedDateTime zonedDateTime = time.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
                System.out.println(zonedDateTime);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
