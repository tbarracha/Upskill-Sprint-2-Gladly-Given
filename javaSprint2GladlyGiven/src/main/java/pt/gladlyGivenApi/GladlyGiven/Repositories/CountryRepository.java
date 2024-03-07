// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.gladlyGivenApi.GladlyGiven.Models.Country;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByCountryIgnoreCase(String country);
}
