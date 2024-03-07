// Author: Tiago Barracha, Hugo Lopes
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;

@Entity
public class PhoneNumber {
    @Id
    @Column(unique = true)
    @Max(16)
    public String number;

    public PhoneNumber() {

    }

    public PhoneNumber(String language) {
        this.number = language;
    }
}
