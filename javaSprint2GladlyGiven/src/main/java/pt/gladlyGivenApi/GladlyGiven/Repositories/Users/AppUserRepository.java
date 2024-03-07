// Author: Tiago Barracha, Hugo Lopes
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Repositories.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.AppUser;

import java.util.Optional;

/**
 * Base repository for all JpaRepositories related to the AppUser and its child classes
 * @param <T concrete child class implementation of AppUser>
 */
@NoRepositoryBean
public interface AppUserRepository<T extends AppUser> extends JpaRepository<T, Long> {
    Optional<T> findByFirstNameIgnoreCase(String firstName); // page?

    Optional<T> findByLastNameIgnoreCase(String lastName); // page?

    Optional<T> findByEmail(Email email);
}
