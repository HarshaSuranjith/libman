package lk.nsbm.dea2.libman.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@DiscriminatorValue(value = "2")
public class Student extends User {

    private String studentId;

}
