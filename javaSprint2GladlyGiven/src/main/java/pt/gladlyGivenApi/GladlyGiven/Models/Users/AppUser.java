package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.*;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;

import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class AppUser {

    @Id
    public long id;
    public String firstName;
    public String lastName;
    //private Language mainLanguage;
    //List<Language> languages = new ArrayList<>();
    public String email;
    public String gender;
    //List<PhoneNumber> phone;
    public String password;
    public String photoURL;
    public String creationDate;


    public AppUser() {

    }

    public AppUser(String firstName, String lastName, String email, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }



    public AppUser(long id, String firstName, String lastName, Language mainLanguage, List<Language> languages, String email, String gender, List<PhoneNumber> phone, String password, String photoURL, Date creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.mainLanguage = mainLanguage;
        //this.languages = languages;
        this.email = email;
        this.gender = gender;
        //this.phone = phone;
        this.password = password;
        this.photoURL = photoURL;
        //this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
