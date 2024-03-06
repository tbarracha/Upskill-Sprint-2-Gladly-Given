// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import pt.gladlyGivenApi.GladlyGiven.Models.Contact.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Geographic.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.Contact.PhoneNumber;

public class AppUserDTO {

    public String firstName;

    public String lastName;

    public Email email;

    public String gender;

    public String photoURL;

    public Language mainLanguage;

    //public List<Language> languages;

    public PhoneNumber mainPhoneNumber;

    //public List<PhoneNumber> phoneNumbers;


    public AppUserDTO() {

    }

    public AppUserDTO(String firstName, String lastName, Email email, String gender, String photoURL, Language mainLanguage, PhoneNumber mainPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.photoURL = photoURL;
        this.mainLanguage = mainLanguage;
        this.mainPhoneNumber = mainPhoneNumber;
    }
}
