package com.matskevich.springcourse.services;

import com.matskevich.springcourse.models.Book;
import com.matskevich.springcourse.models.Person;
import com.matskevich.springcourse.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(boolean sortByYear) {
        if (sortByYear)
            return bookRepository.findAll(Sort.by("yearOfPublishing"));
        else
            return bookRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = bookRepository.findById(id);

        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        bookRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public Optional<Person> findBookOwner(int id) {
        Optional<Person> bookOwner = bookRepository.findById(id).map(Book::getBookOwner);
        return bookOwner;
    }

    @Transactional
    public void release(int id) {
        bookRepository.findById(id).ifPresent(book -> book.setBookOwner(null));
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        bookRepository.findById(id).ifPresent(book -> book.setBookOwner(selectedPerson));
    }
}