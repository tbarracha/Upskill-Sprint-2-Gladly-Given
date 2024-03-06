package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Entity;

@Entity
public class Refugee extends AppUser {
    public String protocolId;

    public String snsNumber;

    public String nationality;

    public String country;


}
