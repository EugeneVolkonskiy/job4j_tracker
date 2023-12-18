package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EditActionTest {

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        UserAction edit = new EditAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
        );
    }

    @Test
    public void whenItemWasNotReplaced() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        UserAction edit = new EditAction(out);
        Input input = mock(Input.class);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Ошибка замены заявки." + ln
        );
    }
}