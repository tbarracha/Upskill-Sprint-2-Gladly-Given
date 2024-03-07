// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;

@MappedSuperclass
public abstract class MonetaryUser<T extends MonetaryUser, DTO extends AppUserDTO> extends AppUser<T, DTO> {
    @Max(16)
    public String nif;

    @Max(32)
    public String paymentInfoId; // fetched from Entity Framework API

    @Max(32)
    public String invoiceInfoId; // fetched from Entity Framework API

    public MonetaryUser() {

    }

    public MonetaryUser(String firstName, String lastName, Email email, String gender, String password, Language language, PhoneNumber phoneNumber, String nif) {
        super(firstName, lastName, email, gender, password, language, phoneNumber);
        this.nif = nif;
    }

    public MonetaryUser(String firstName, String lastName, Email email, String gender, String password, Language language, PhoneNumber phoneNumber, String nif, String paymentInfoId, String invoiceInfoId) {
        super(firstName, lastName, email, gender, password, language, phoneNumber);
        this.nif = nif;
        this.paymentInfoId = paymentInfoId;
        this.invoiceInfoId = invoiceInfoId;
    }
}
