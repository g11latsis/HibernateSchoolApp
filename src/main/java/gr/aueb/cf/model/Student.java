package gr.aueb.cf.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STUDENTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends AbstractEntity{

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "BIRTHDATE")
    private String birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID", referencedColumnName = "id")
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "student")
    private Set<Meeting> meetings = new HashSet<>();

    public Set<Meeting> getAllMeetings(){
        return Collections.unmodifiableSet(meetings);
    }

    public void addMeeting(Meeting meeting) {
        if (!getMeetings().contains(meeting)) {
            getMeetings().add(meeting);
            meeting.setStudent(this);
        }
    }


    public void removeMeeting(Meeting meeting) {
        if (getMeetings().contains(meeting)) {
            getMeetings().remove(meeting);
            meeting.setStudent(null);
        }
    }



    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", city=" + city +
                ", user=" + user +
                '}';
    }
}

