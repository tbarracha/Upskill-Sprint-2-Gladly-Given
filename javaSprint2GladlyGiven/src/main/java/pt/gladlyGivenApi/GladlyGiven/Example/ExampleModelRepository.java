// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExampleModelRepository extends JpaRepository<ExampleModel, Integer> {
    Optional<ExampleModel> findByName(String name);
}
