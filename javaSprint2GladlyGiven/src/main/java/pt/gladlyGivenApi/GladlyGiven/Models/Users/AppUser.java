package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String firstName;
    public String lastName;

    // TODO: language
    // TODO: list of languages
    // TODO: email

    public String password;
    public String photoURL;
    public String creationDate;

    public AppUser() {

    }

    public AppUser(String firstName, String lastName, String password, String creationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.creationDate = creationDate;
    }

    public AppUser(String firstName, String lastName, String password, String photoURL, String creationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.photoURL = photoURL;
        this.creationDate = creationDate;
    }
}