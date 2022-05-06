package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComparatorTest {
    @Test
    public void whenAsc() {
        List<Item> items = Arrays.asList(
                new Item(2, "B"),
                new Item(3, "C"),
                new Item(1, "A")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "A"),
                new Item(2, "B"),
                new Item(3, "C")
        );
        assertThat(expected, is(items));
    }

    @Test
    public void whenDesc() {
        List<Item> items = Arrays.asList(
                new Item(2, "B"),
                new Item(3, "C"),
                new Item(1, "A")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "C"),
                new Item(2, "B"),
                new Item(1, "A")
        );
        assertThat(expected, is(items));
    }
}