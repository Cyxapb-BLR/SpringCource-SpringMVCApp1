package com.matskevich.springcourse.dao;

import com.matskevich.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Vadim"));
        people.add(new Person(++PEOPLE_COUNT, "Кацянятка"));
        people.add(new Person(++PEOPLE_COUNT, "Slayer"));
        people.add(new Person(++PEOPLE_COUNT, "Vera"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        //people.set(id, updatedPerson);
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }
}
