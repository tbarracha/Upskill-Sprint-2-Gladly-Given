// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.gladlyGivenApi.GladlyGiven.Models.ExampleModel;

import java.util.Optional;

public interface ExampleModelRepository extends JpaRepository<ExampleModel, Integer> {
    Optional<ExampleModel> findByNameIgnoreCase(String name);
}
