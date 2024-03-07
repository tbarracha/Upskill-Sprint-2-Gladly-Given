// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models;

import jakarta.persistence.*;

@Entity
public class ExampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    public ExampleModel() {

    }

    public ExampleModel(String name) {
        this.name = name;
    }
}
