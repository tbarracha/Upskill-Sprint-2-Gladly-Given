// Author: Tiago Barracha, Hugo Lopes
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import pt.gladlyGivenApi.GladlyGiven.Interfaces.IDTOable;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;

/**
 * Base abstract class for all AppUser Types
 * @param <T concrete child class >
 */
@MappedSuperclass
public abstract class AppUser<T, DTO> implements IDTOable<DTO> {
    @Id
    @Min(1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Max(32)
    @Column(nullable = false)
    public String firstName;

    @Max(32)
    public String lastName;

    @ManyToOne
    public Email email;

    public String gender;

    public String password;

    public String photoURL;

    public String creationDate;

    @ManyToOne
    public Language mainLanguage;

    //List<Language> languages = new ArrayList<>();

    @ManyToOne
    public PhoneNumber mainPhoneNumber;

    //List<PhoneNumber> phone;


    public AppUser() {

    }


    public AppUser(String firstName, String lastName, Email email, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public AppUser(String firstName, String lastName, Email email, String gender, String password, Language language, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.mainLanguage = language;
        this.mainPhoneNumber = phoneNumber;
    }
}
