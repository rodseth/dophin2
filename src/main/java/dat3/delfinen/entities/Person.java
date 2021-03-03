
package dat3.delfinen.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author MariHaugen
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;
    
    private String name;
    private int yearOfBirth;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Fee> fees;
    
    @ManyToMany (mappedBy = "persons", cascade = CascadeType.PERSIST)
    private List<SwimStyle> swimStyles;

    public Person() {
    }

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.fees =  new ArrayList<>();
        this.swimStyles = new ArrayList<>();
        
    }

    public Long getP_id() {
        return p_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            address.setPerson(this);
        }
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void addFee(Fee fee) {
        this.fees.add(fee);
        if (fee != null) {
            fee.setPerson(this);
        }
    }
    
    public void addSwimStyle (SwimStyle swimStyle) {
        
        if (swimStyle != null) {
            this.swimStyles.add(swimStyle);
            swimStyle.getPersons().add(this);
        }
    }
    
    public void removeSwimStyle (SwimStyle swimStyle) {
        if (swimStyle != null) {
            swimStyles.remove(swimStyle);
            swimStyle.getPersons().remove(this);
        }
    }
    
}
