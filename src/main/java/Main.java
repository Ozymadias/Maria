import message.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("utrwalacz");

    public static void main(String[] args) {
        clean();

        create(1, "Witaj Świecie");
        create(2, "Witaj JPA");
        create(3, "Witaj Hiberze");

        readAll();
    }

    private static void readAll() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
//        em.getCriteriaBuilder().
        em.createNativeQuery("SELECT * FROM content", Message.class).getResultList().forEach(System.out::println);
//        em.createQuery("SELECT id, text FROM content", Message.class).getResultList().forEach(System.out::println);
//        CriteriaBuilder
        et.commit();
        em.close();
    }

    private static void create(int i, String message) {
        Message msg = new Message(i, message);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(msg);
//        em.createNativeQuery("INSERT INTO content (id, text) VALUES (?,?)").setParameter(i, message);
        em.getTransaction().commit();
        em.close();
    }

    private static void clean() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("DELETE FROM content").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
