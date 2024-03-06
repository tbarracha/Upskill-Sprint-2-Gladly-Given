package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;

import java.util.Date;
import java.util.List;

public abstract class MonetaryUser extends AppUser {
    private String nif;
    //paymentInfo : PaymentInfo
    //invoiceInfo : InvoiceInfo

    public MonetaryUser() {
    }

    public MonetaryUser(long id, String firstName, String lastName, Language mainLanguage, List<Language> languages, String email, String gender, List<PhoneNumber> phone, String password, String photoURL, Date creationDate, String nif) {
        super(id, firstName, lastName, mainLanguage, languages, email, gender, phone, password, photoURL, creationDate);
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
}
