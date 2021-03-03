
package dto;

/**
 *
 * @author MariHaugen
 */
public class PersonFeeDTO {
    
    private String name;
    private int yearOfBirth;
    private int amount;

    public PersonFeeDTO(String name, int yearOfBirth, int amount) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}
