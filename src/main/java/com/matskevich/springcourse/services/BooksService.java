package com.matskevich.springcourse.services;

import com.matskevich.springcourse.models.Book;
import com.matskevich.springcourse.models.Person;
import com.matskevich.springcourse.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        Book bookToBeUpdated = booksRepository.findById(id).get();

        updatedBook.setId(id);
        updatedBook.setBookOwner(bookToBeUpdated.getBookOwner());

        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public Optional<Person> findBookOwner(int id) {
        return booksRepository.findById(id).map(Book::getBookOwner);
    }

    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(
                book -> book.setBookOwner(null)
        );
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        booksRepository.findById(id).ifPresent(
                book -> book.setBookOwner(selectedPerson));
    }
}
