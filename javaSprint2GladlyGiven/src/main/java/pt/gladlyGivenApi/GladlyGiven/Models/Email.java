// Author: Tiago Barrach
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Email {
    @Id
    public String email;

    public Email() {

    }

    public Email(String email) {
        this.email = email;
    }
}
