package lk.nsbm.dea2.libman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
    @SequenceGenerator(name = "book_seq_gen")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn", updatable = false)
    private String isbn;

    @Column(name = "classification")
    private String classification;

    @Column(name = "section")
    private Section section;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.DETACH)
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id", referencedColumnName = "id"))
    private Set<Author> authors;

    @OneToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_book_publisher"))
    private Publisher publisher;

    @JsonIgnore
    public boolean isValid() {
        return title != null && !title.isEmpty()
                && isbn != null && !isbn.isEmpty()
                && section != null
                && authors != null && !authors.isEmpty();
    }
}
