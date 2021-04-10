package lk.nsbm.dea2.libman.service.Impl;

import lk.nsbm.dea2.libman.dataaccess.AuthorRepository;
import lk.nsbm.dea2.libman.model.Author;
import lk.nsbm.dea2.libman.service.AuthorManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorManagementServiceImpl implements AuthorManagementService {

    private AuthorRepository authorRepository;

    @Override
    public Author add(Author author) {
        Author saved = this.authorRepository.save(author);
        return saved;
    }

    @Override
    public Author update() {
        return null;
    }

    @Override
    public Author get(Integer id) {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
