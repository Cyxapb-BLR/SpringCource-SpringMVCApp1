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

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT p FROM Person p", Person.class).getResultList();

    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();

        session.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);

        person.setName(updatedPerson.getName());
        person.setYearOfBirth(updatedPerson.getYearOfBirth());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(Person.class, id));
    }

    /*public List<Book> getBookByPersonId(int id) {

        return jdbcTemplate.query("Select * FROM Book WHERE person_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }*/
}
