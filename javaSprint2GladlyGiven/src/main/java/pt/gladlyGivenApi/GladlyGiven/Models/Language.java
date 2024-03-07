// Author: Tiago Barracha, Hugo Lopes
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    @Max(32)
    public String language;

    public Language() {

    }

    public Language(String language) {
        this.language = language;
    }
}
