package lk.nsbm.dea2.libman.service;

import lk.nsbm.dea2.libman.model.Author;

public interface AuthorManagementService {


    Author add(Author author);

    Author update();

    Author get(Integer id);

    boolean delete();

}
