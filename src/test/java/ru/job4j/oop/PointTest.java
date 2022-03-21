package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PointTest {

    @Test
    public void when301and402Then1Dot414() {
        Point a = new Point(3, 0, 1);
        Point b = new Point(4, 0, 2);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(1.414, 0.001));
    }

    @Test
    public void when928and465Then7Dot071() {
        Point a = new Point(9, 2, 8);
        Point b = new Point(4, 6, 5);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(7.071, 0.001));
    }
}