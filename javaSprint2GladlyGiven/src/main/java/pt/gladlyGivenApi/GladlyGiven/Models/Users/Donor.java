// Author: Tiago Barrach
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Entity;

@Entity
public class Donor extends MonetaryUser<Donor, DonorDTO> {


    @Override
    public DonorDTO toDTO() {
        return null;
    }
}
