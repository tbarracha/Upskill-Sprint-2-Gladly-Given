package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Entity;

@Entity
public class Donor extends MonetaryUser<Donor> {


    @Override
    public Donor toDTO() {
        return null;
    }
}
