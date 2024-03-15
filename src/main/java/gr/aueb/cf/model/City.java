package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CITIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City extends AbstractEntity{
    @Column(name = "CITY")
    private String city;

    @OneToMany(mappedBy = "city")
    @Getter(AccessLevel.PRIVATE)
    private Set<Student> students = new HashSet<>();

    public Set<Student> getAllStudents(){
        return Collections.unmodifiableSet(students);
    }
}
