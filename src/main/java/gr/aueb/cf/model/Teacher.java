package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TEACHERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher extends AbstractEntity{

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPECIALITY_ID", referencedColumnName = "id")
    private Speciality speciality;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "teacher")
    private Set<Meeting> meetings = new HashSet<>();

    public Set<Meeting> getAllMeetings(){
        return Collections.unmodifiableSet(meetings);
    }

    public void addMeeting(Meeting meeting) {
        if (!getMeetings().contains(meeting)) {
            getMeetings().add(meeting);
            meeting.setTeacher(this);
        }
    }

    public void removeMeeting(Meeting meeting) {
        if (getMeetings().contains(meeting)) {
            getMeetings().remove(meeting);
            meeting.setTeacher(null);
        }
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality=" + speciality +
                ", user=" + user +
                '}';
    }
}
