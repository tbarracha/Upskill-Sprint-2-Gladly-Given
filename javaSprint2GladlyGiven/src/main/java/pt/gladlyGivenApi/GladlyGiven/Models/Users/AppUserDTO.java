// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;

public abstract class AppUserDTO {

    public String firstName;

    public String lastName;

    public String email;

    public String gender;

    public String photoURL;

    public String mainLanguage;

    //public List<Language> languages;

    public String mainPhoneNumber;

    //public List<PhoneNumber> phoneNumbers;


    public AppUserDTO() {

    }

    public AppUserDTO(String firstName, String lastName, String email, String gender, String photoURL, String mainLanguage, String mainPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.photoURL = photoURL;
        this.mainLanguage = mainLanguage;
        this.mainPhoneNumber = mainPhoneNumber;
    }
}
