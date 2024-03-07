// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Repositories.Users;

import pt.gladlyGivenApi.GladlyGiven.Models.Users.ServiceProvider;

import java.util.Optional;

public interface ServiceProviderRepository extends AppUserRepository<ServiceProvider> {
    Optional<ServiceProvider> findByLicenseNumber(String licenseNumber);
}
