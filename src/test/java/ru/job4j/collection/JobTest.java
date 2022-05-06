package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobTest {
    @Test
    public void whenCompareDescByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("C", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareAscByNameAndAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareAscByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("C", 0),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareDescByNameAndAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("C", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("C", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareAscByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("C", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}