package lk.nsbm.dea2.libman.dataaccess;

import lk.nsbm.dea2.libman.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
