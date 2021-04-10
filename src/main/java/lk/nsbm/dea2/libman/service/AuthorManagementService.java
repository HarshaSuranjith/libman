package lk.nsbm.dea2.libman.service;

import lk.nsbm.dea2.libman.model.Author;

import java.util.Optional;

public interface AuthorManagementService {


    Author add(Author author);

    Author update(Author author);

    Author get(Integer id);

    boolean delete(Long id);

    Optional<Author> findById(Long id);
}
