package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;

@Entity
public class Refugee extends AppUser {
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

    public Refugee(String firstName, String lastName, String email, String gender, String password, String protocolId, String snsNumber, String nationality, String country) {
        super(firstName, lastName, email, gender, password);
        this.protocolId = protocolId;
        this.snsNumber = snsNumber;
        this.nationality = nationality;
        this.country = country;
    }
}
