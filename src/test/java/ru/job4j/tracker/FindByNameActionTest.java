package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    public void whenItemWasFoundByNameSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Test item");
        tracker.add(item);
        UserAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item
                        + ln
        );
    }

    @Test
    public void whenItemWasNotFoundByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Test item");
        tracker.add(item);
        UserAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        String testName = "Test";
        when(input.askStr(any(String.class))).thenReturn(testName);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + testName + " не найдены."
                        + ln
        );
    }
}