package com.matskevich.springcourse.dao;

import com.matskevich.springcourse.models.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title, author, year_of_publishing) values (?,?,?)",
                book.getTitle(), book.getAuthor(), book.getYearOfPublishing());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET title=?,author=?,year_of_publishing=? WHERE id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYearOfPublishing(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
