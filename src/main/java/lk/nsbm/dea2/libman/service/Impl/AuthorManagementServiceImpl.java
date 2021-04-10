package lk.nsbm.dea2.libman.service.Impl;

import lk.nsbm.dea2.libman.dataaccess.AuthorRepository;
import lk.nsbm.dea2.libman.model.Author;
import lk.nsbm.dea2.libman.service.AuthorManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorManagementServiceImpl implements AuthorManagementService {

    private AuthorRepository authorRepository;

    @Override
    public Author add(Author author) {
        Author saved = this.authorRepository.save(author);
        return saved;
    }

    @Override
    public Author update(Author author) {
        Author updated = this.authorRepository.save(author);
        return updated;
    }

    @Override
    public Author get(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Author> toDelete = this.authorRepository.findById(id);
        if (toDelete.isPresent()) {
            this.authorRepository.delete(toDelete.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
