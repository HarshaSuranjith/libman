package lk.nsbm.dea2.libman.service.Impl;

import lk.nsbm.dea2.libman.dataaccess.BookRepository;
import lk.nsbm.dea2.libman.model.Book;
import lk.nsbm.dea2.libman.service.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookManagementServiceImpl implements BookManagementService {
    private BookRepository bookRepository;

    @Autowired
    public BookManagementServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        Book updated = this.bookRepository.save(book);
        return updated;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }
}
