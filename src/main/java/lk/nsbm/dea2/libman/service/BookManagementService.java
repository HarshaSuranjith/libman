package lk.nsbm.dea2.libman.service;

import lk.nsbm.dea2.libman.model.Book;

import java.util.Optional;

public interface BookManagementService {

    Book add(Book book);

    Book update(Book book);

    Optional<Book> findByIsbn(String isbn);
}
