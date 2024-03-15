package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "MEETINGS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meeting extends AbstractEntity{

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "STUDENT_ID")
        private Student student;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "TEACHER_ID")
        private Teacher teacher;

        @Column(name = "MEETING_ROOM")
        private String meetingRoom;

        @Column(name = "MEETING_DATE")
        private String meetingDate;

        @Override
        public String toString() {
                return "Meeting{" +
                        "student=" + student +
                        ", teacher=" + teacher +
                        ", meetingRoom='" + meetingRoom + '\'' +
                        ", meetingDate='" + meetingDate + '\'' +
                        '}';
        }
}

