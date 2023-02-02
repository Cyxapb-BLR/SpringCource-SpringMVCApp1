package com.matskevich.springcourse.dao;

import com.matskevich.springcourse.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class BookDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Book> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public Book show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Book.class, id);
    }

    @Transactional
    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();

        session.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setYearOfPublishing(updatedBook.getYearOfPublishing());

    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);

        session.remove(book);
    }

    /*public Optional<Person> getBookOwner(int id) {
        Session session = sessionFactory.getCurrentSession();


        return jdbcTemplate.query("SELECT Person.* FROM Person JOIN Book B on Person.id = B.person_id WHERE B.id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    @Transactional
    public void release(int id) {
        Session session = sessionFactory.getCurrentSession();

        Book book = session.get(Book.class, id);


        jdbcTemplate.update("UPDATE Book SET person_id=null where id=?", id);
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        Session session = sessionFactory.getCurrentSession();

        Book book = session.get(Book.class, id);

        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }*/
}
