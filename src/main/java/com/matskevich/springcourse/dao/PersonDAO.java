package com.matskevich.springcourse.dao;

import com.matskevich.springcourse.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        // regular hibernate code

        return null;
    }

    public Person show(int id) {        // into "?" insert object with id
        return null;
    }

    public void save(Person person) {

    }

    public void update(int id, Person updatedPerson) {

    }

    public void delete(int id) {

    }
}
