package pt.gladlyGivenApi.GladlyGiven.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public abstract class AppUser {

private long id;
private String firstName;
private String lastName;
private Language mainLanguage;
List<Language> languages = new ArrayList<>();
private String email;
private String gender;
List<PhoneNumber> phone;
private String password;
private String photoURL;
private DateTimeFormatter creationDate;

    public AppUser(long id, String firstName, String lastName, Language mainLanguage, List<Language> languages, String email, String gender, List<PhoneNumber> phone, String password, String photoURL, DateTimeFormatter creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainLanguage = mainLanguage;
        this.languages = languages;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
        this.photoURL = photoURL;
        this.creationDate = creationDate;
    }


}
