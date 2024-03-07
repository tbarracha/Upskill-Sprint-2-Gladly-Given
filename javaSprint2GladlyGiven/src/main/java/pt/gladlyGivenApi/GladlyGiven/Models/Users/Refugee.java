// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Country;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;

@Entity
public class Refugee extends AppUser<Refugee, RefugeeDTO> {
    @Max(16)
    public String protocolId;

    @Max(16)
    public String snsNumber;

    @Max(16)
    public String nationality;

    @Max(32)
    @ManyToOne
    public Country country;

    public Refugee() {
        super();
    }

    public Refugee(String firstName, String lastName, Email email, String gender, String password, String protocolId, String snsNumber, String nationality) {
        super(firstName, lastName, email, gender, password);
        this.protocolId = protocolId;
        this.snsNumber = snsNumber;
        this.nationality = nationality;
    }

    public Refugee(String firstName, String lastName, Email email, String gender, String password, String protocolId, String snsNumber, String nationality, Country country, Language language, PhoneNumber phoneNumber) {
        super(firstName, lastName, email, gender, password, language, phoneNumber);
        this.protocolId = protocolId;
        this.snsNumber = snsNumber;
        this.nationality = nationality;
        this.country = country;
    }

    @Override
    public RefugeeDTO toDTO() {
        return new RefugeeDTO(
                firstName,
                lastName,
                email.email,
                gender,
                photoURL,
                mainLanguage.language,
                mainPhoneNumber.number,
                protocolId,
                snsNumber,
                nationality,
                country.country
        );
    }
}
