package gr.aueb.cf;



import gr.aueb.cf.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Speciality maths = new Speciality();
        maths.setSpeciality("Mathematician");

        Meeting meeting = new Meeting();
        meeting.setMeetingRoom("Room 101");
        meeting.setMeetingDate("2024-03-15");

        Student student = new Student();
        student.setFirstName("Alice");
        student.setLastName("Smith");
        student.setBirthDate("1990-01-01");

        Teacher teacher = new Teacher();
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        teacher.setSpeciality(maths);

        meeting.setStudent(student);
        meeting.setTeacher(teacher);

        em.persist(maths);
        em.persist(meeting);
        em.persist(student);
        em.persist(teacher);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
