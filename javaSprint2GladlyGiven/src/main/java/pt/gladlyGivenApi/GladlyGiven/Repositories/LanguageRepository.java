// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Optional<Language> findByLanguageIgnoreCase(String language);
}
