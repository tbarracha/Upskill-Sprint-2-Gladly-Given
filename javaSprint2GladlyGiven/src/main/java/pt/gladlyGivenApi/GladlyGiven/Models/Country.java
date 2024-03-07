// Author: Tiago Barrach
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country {
    @Id
    public Long id;

    @Column(unique = true)
    public String country;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }
}
