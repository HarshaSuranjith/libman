package lk.nsbm.dea2.libman.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "lending_policy")
public class LendingPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publish_seq_gen")
    @SequenceGenerator(name = "publish_seq_gen")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "ref_count", nullable = false)
    private int referenceBooksCount;

    @Column(name = "ref_max_period", nullable = false)
    private int referenceMaxBorrowingPeriod;

    @Column(name = "lending_count", nullable = false)
    private int lendingBooksCount;

    @Column(name = "lending_max_period", nullable = false)
    private int lendingMaxBorrowingPeriod;

}
