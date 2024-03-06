// Author: Tiago Barracha, Hugo Lopes
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Repositories.Users;

import pt.gladlyGivenApi.GladlyGiven.Models.Users.Refugee;

import java.util.Optional;

public interface RefugeeRepository extends AppUserRepository<Refugee> {
    Optional<Refugee> findByProtocolIdIgnoreCase(String protocolId);
}
