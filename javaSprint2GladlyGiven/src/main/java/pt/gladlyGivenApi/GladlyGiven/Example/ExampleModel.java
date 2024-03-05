package pt.gladlyGivenApi.GladlyGiven.Example;

import jakarta.persistence.*;

@Entity
//@Table(name = "\"ExampleModels\"") // » é obrigatório meter isto para que as tableas fiquem iguais entre o EntityFramework e o IntelliJ!!!
@Table(name = "\"ExampleModel\"")
public class ExampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public ExampleModel(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
