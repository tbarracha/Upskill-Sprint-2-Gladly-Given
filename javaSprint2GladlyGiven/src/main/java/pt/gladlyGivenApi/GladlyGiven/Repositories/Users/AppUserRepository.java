// Author: Tiago Barracha, Hugo Lopes
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Repositories.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pt.gladlyGivenApi.GladlyGiven.Models.Contact.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.AppUser;

import java.util.Optional;

/**
 * Base repository for all Repositories related to the AppUser and its child classes
 * @param <T concrete child class of AppUser>
 */
@NoRepositoryBean
public interface AppUserRepository<T extends AppUser> extends JpaRepository<T, Long> {
    Optional<T> findByFirstNameIgnoreCase(String firstName);

    Optional<T> findByLastNameIgnoreCase(String lastName);

    Optional<T> findByEmail(Email email);
}
