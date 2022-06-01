package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var result = new ArrayList<Person>();
        Predicate<Person> findName = person -> person.getName().contains(key);
        Predicate<Person> findSurname = person -> person.getSurname().contains(key);
        Predicate<Person> findPhone = person -> person.getPhone().contains(key);
        Predicate<Person> findAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = findName.or(findSurname.or(findPhone.or(findAddress)));
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
