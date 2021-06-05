package pl.coderslab.myapplication.student;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "students")
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String name;

    private OffsetDateTime registrationDate;

}
