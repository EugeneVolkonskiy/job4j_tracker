package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDuplicateOrders() {
        List<Order> orders = Arrays.asList(
                new Order("1", "First name"),
                new Order("2", "Second name"),
                new Order("1", "First name")
        );
        HashMap<String, Order> map = OrderConvert.process(orders);
        Set<String> keys = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(map.keySet(), is(keys));
    }
}