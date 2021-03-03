
package dto;

/**
 *
 * @author MariHaugen
 */
public class PersonStyleDTO {
    
    private String name;
    private int yearOfBirth;
    private int numberOfStyles;
    private String styleName;
   
     public PersonStyleDTO(String name, int yearOfBirth, String styleName) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.styleName = styleName;
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

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
    
}
