package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SPECIALITIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Speciality extends AbstractEntity{

    @Column(name = "SPECIALITY")
    private String speciality;

    @OneToMany(mappedBy = "speciality")
    @Getter(AccessLevel.PRIVATE)
    private Set<Teacher> teachers = new HashSet<>();

    public Set<Teacher> getAllTeachers(){
        return Collections.unmodifiableSet(teachers);
    }
}
