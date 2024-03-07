package pt.gladlyGivenApi.GladlyGiven.Models;

import java.util.ArrayList;
import java.util.List;

public class Donor {

    public FiscalIdentity fiscalIdentity;
    List<Donation> donations = new ArrayList<>();

    public Donor() {
    }

    public Donor(FiscalIdentity fiscalIdentity, List<Donation> donations) {
        this.fiscalIdentity = fiscalIdentity;
        this.donations = donations;
    }

}
