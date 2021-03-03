package dat3.delfinen.entities;

import dto.PersonFeeDTO;
import dto.PersonStyleDTO;
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
        Person p3 = new Person("Nikolaj", 1990 );
        Person p4 = new Person("Jon", 1975 );
        Person p5 = new Person("Brian", 1966 );
        Person p6 = new Person("Anette", 1968 );
        Person p7 = new Person("Torhild", 1952 );
        Person p8 = new Person("John", 1944 );
        Person p9 = new Person("Tone", 1975 );
        Person p10 = new Person("Kristin", 1971 );
       
        
        Address a1 = new Address("Stensebyvejen 2", 3730, "Nexø");
        Address a2 = new Address("Gl. Rønnevej 23", 3730, "Nexø");
        Address a3 = new Address("Strømdalkåsa 4", 3727, "Skien");
        Address a4 = new Address("Gøteborggata 14g", 0556, "Oslo");
        Address a5 = new Address("Akersborg Terasse", 1852, "Oslo"); //hvorfor kan jeg ikke ha 0582
        Address a6 = new Address("Rønne Torg 1", 3700, "Rønne");
        Address a7 = new Address("Ørnevej 8", 2400, "København");
        Address a8 = new Address("Douch Alle 5", 6200, "Tarm");
        Address a9 = new Address("Svedsevej 68", 2100, "Tåstrup");
        Address a10 = new Address("Gabvej", 6666, "Søvnby");
        
        p1.setAddress(a1);
        p2.setAddress(a2);
        p3.setAddress(a3);
        p4.setAddress(a4);
        p5.setAddress(a5);
        p6.setAddress(a6);
        p7.setAddress(a7);
        p8.setAddress(a8);
        p9.setAddress(a9);
        p10.setAddress(a10);
        
        
        Fee f1 = new Fee(100);
        Fee f2 = new Fee(150);
        Fee f3 = new Fee(200);
        Fee f4 = new Fee(100);
        Fee f5 = new Fee(150);
        Fee f6 = new Fee(300);
        Fee f7 = new Fee(175);
        Fee f8 = new Fee(160);
        Fee f9 = new Fee(250);
        Fee f10 = new Fee(200);
        Fee f11 = new Fee(150);
        Fee f12 = new Fee(200);
        Fee f13 = new Fee(500);
        Fee f14 = new Fee(350);
        Fee f15 = new Fee(275);
        Fee f16 = new Fee(50);
        Fee f17 = new Fee(150);
        Fee f18 = new Fee(200);
        
        
        p1.addFee(f1);
        p2.addFee(f2);
        p2.addFee(f3);
        p3.addFee(f4);
        p4.addFee(f5);
        p4.addFee(f6);
        p5.addFee(f7);
        p5.addFee(f8);
        p5.addFee(f9);
        p5.addFee(f10);
        p6.addFee(f11);
        p7.addFee(f12);
        p7.addFee(f13);
        p8.addFee(f14);
        p9.addFee(f15);
        p9.addFee(f16);
        p9.addFee(f17);
        p9.addFee(f18);
        
        SwimStyle s1 = new SwimStyle("Breast Stroke");
        SwimStyle s2 = new SwimStyle("Crawl");
        SwimStyle s3 = new SwimStyle("Back Stroke");
        SwimStyle s4 = new SwimStyle("Butterfly");
      
        
        p1.addSwimStyle(s4);
        p1.addSwimStyle(s3);
        p1.addSwimStyle(s2);
        p1.addSwimStyle(s1);
        p2.addSwimStyle(s4);
        p2.addSwimStyle(s2);
        p2.addSwimStyle(s3);
        p3.addSwimStyle(s4);
        p4.addSwimStyle(s1);
        p4.addSwimStyle(s3);
        p5.addSwimStyle(s1);
        p5.addSwimStyle(s2);
        p6.addSwimStyle(s4);
        p7.addSwimStyle(s1);
        p7.addSwimStyle(s2);
        p7.addSwimStyle(s3);
        p7.addSwimStyle(s4);
        p8.addSwimStyle(s4);
        p8.addSwimStyle(s3);
        p9.addSwimStyle(s2);
        p9.addSwimStyle(s3);
        p10.addSwimStyle(s1);
        
        em.getTransaction().begin();
        
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);
            em.persist(p6);
            em.persist(p7);
            em.persist(p8);
            em.persist(p9);
            em.persist(p10);
            
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        
            p2.removeSwimStyle(s3);
            
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
            System.out.println(f.getPerson().getName()+ " har betalt " + f.getAmount() + "kr, den " + f.getPayDate() + ". " + f.getPerson().getAddress().getCity());
        
        TypedQuery<PersonFeeDTO> q2 = em.createQuery("SELECT new dto.PersonFeeDTO(p.name, p.yearOfBirth, f.amount) FROM Person p JOIN p.fees f", dto.PersonFeeDTO.class);
        List<PersonFeeDTO> personFeeList =  q2.getResultList();
        
        for (PersonFeeDTO p: personFeeList){
            System.out.println(p.getName() + ", " + p.getYearOfBirth() + ", " + p.getAmount());
        }
        
        TypedQuery<PersonStyleDTO> q3 = em.createQuery("SELECT new dto.PersonStyleDTO(p.name, p.yearOfBirth, s.styleName) FROM Person p JOIN p.swimStyles s", dto.PersonStyleDTO.class);
        List<PersonStyleDTO> personStyleList =  q3.getResultList();
        
        for (PersonStyleDTO p: personStyleList){
            System.out.println(p.getName() + ", " + p.getYearOfBirth() + ", " + p.getStyleName());
        }
        
        TypedQuery<PersonStyleDTO> q4 = em.createQuery("SELECT new dto.PersonStyleDTO(p.name, p.yearOfBirth, s.styleName) FROM Person p JOIN p.styles s WHERE s.styleName = Crawl", dto.PersonStyleDTO.class);
        List<PersonStyleDTO> personList =  q4.getResultList();
        
        for (PersonStyleDTO p: personList){
            System.out.println(p.getName() + ", " + p.getYearOfBirth() + ", " + p.getStyleName());
        }
        
        

    }
}