package gr.aueb.cf;



import gr.aueb.cf.model.Meeting;
import gr.aueb.cf.model.Student;
import gr.aueb.cf.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Bob");
        teacher1.setLastName("Ross");

        Student student1 = new Student();
        student1.setFirstName("Mike");
        student1.setLastName("James");

        Meeting meeting1 = new Meeting();
        meeting1.setMeetingRoom("Room 102");
        meeting1.setMeetingDate("2024-05-25");

        teacher1.addMeeting(meeting1);
        student1.addMeeting(meeting1);

        System.out.println("Teacher's meetings: " + teacher1.getMeetings());
        System.out.println("Student's meetings: " + student1.getMeetings());


        teacher1.removeMeeting(meeting1);
        student1.removeMeeting(meeting1);

        System.out.println("Teacher's meetings after removal: " + teacher1.getMeetings());
        System.out.println("Student's meetings after removal: " + student1.getMeetings());

        em.persist(teacher1);
        em.persist(student1);
        em.persist(meeting1);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
