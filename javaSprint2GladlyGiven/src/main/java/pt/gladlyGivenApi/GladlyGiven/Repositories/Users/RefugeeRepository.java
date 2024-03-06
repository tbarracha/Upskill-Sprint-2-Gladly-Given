package pt.gladlyGivenApi.GladlyGiven.Repositories.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.Refugee;

import java.util.Optional;

public interface RefugeeRepository extends JpaRepository<Refugee, Long> {
    Optional<Refugee> findRefugeeByFirstName(String firstName);

    Optional<Refugee> findRefugeeByLastName(String lastName);

    Optional<Refugee> findRefugeeByEmail(String email);

    Optional<Refugee> findRefugeeByProtocolId(String protocolId);
}
