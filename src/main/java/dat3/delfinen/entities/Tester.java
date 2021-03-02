package dat3.delfinen.entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
        
        Fee f1 = new Fee(100);
        Fee f2 = new Fee(150);
        Fee f3 = new Fee(200);
        
        p1.addFee(f1);
        p2.addFee(f2);
        p2.addFee(f3);
        
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
        
        System.out.println("Hvem har betalt f2? Det har: " + f2.getPerson().getName());
        System.out.println("Hva har blitt betalt?");
        
        TypedQuery q1 = em.createQuery("SELECT f FROM Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();
        for(Fee f : fees)
            System.out.println(f.getPerson().getName()+ "har betalt " + f.getAmount() + "kr, den " + f.getPayDate() + ". " + f.getPerson().getAddress().getCity());

    }
}