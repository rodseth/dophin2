package dat3.delfinen.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MariHaugen
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Person p1 = new Person("Mari", 1985 );
        Person p2 = new Person("Frank", 2012 );
        
        Address a1 = new Address("Stensebyvejen 2", 3730, "Nexø");
        Address a2 = new Address("Gl. Rønnevej 23", 3730, "Nexø");
        
        p1.setAddress(a1);
        p2.setAddress(a2);
        
        em.getTransaction().begin();
        
            em.persist(p1);
            em.persist(p2);
            
        em.getTransaction().commit();
        
        System.out.println("p1: " + p1.getP_id() + ", " + p1.getName());
        System.out.println("p2: " + p2.getP_id() + ", " + p2.getName());
        System.out.println("Franks gate er: " + p2.getAddress().getStreet());
        
        System.out.println("La oss se on det virker begge veier, hvem bor på addresse a1: " + a1.getPerson().getName());

    }
}