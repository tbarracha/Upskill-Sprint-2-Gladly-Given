// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import pt.gladlyGivenApi.GladlyGiven.Models.Contact.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Geographic.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.Contact.PhoneNumber;

@Entity
public class Refugee extends AppUser<Refugee> {
    @Max(16)
    public String protocolId;

    @Max(16)
    public String snsNumber;

    @Max(16)
    public String nationality;

    @Max(32)
    public String country;

    public Refugee() {
        super();
    }

    public Refugee(String firstName, String lastName, Email email, String gender, String password, String protocolId, String snsNumber, String nationality, String country) {
        super(firstName, lastName, email, gender, password);
        this.protocolId = protocolId;
        this.snsNumber = snsNumber;
        this.nationality = nationality;
        this.country = country;
    }

    public Refugee(String firstName, String lastName, Email email, String gender, String password, String protocolId, String snsNumber, String nationality, String country, Language language, PhoneNumber phoneNumber) {
        super(firstName, lastName, email, gender, password, language, phoneNumber);
        this.protocolId = protocolId;
        this.snsNumber = snsNumber;
        this.nationality = nationality;
        this.country = country;
    }

    @Override
    public Refugee toDTO() {
        return null;
    }
}
