package pt.gladlyGivenApi.GladlyGiven.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.ServiceProvider;
import pt.gladlyGivenApi.GladlyGiven.Repositories.Users.ServiceProviderRepository;

@Service
public class ServiceProviderService extends AppUserService {

    // Repositories
    // ---------------------------------------------------------------------
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;



    // Service Provider
    // ---------------------------------------------------------------------
    // find ---
    public ServiceProvider findById(Long id) {
        return findUserById(id, serviceProviderRepository);
    }

    public ServiceProvider findByEmail(String email) {
        return findUserByEmail(email, serviceProviderRepository);
    }

    public ServiceProvider findByFirstName(String firstName) {
        return findUserByFirstName(firstName, serviceProviderRepository);
    }

    public ServiceProvider findByLastName(String lastName) {
        return findUserByLastName(lastName, serviceProviderRepository);
    }

    public ServiceProvider findByLicenseNumber(String licenseNumber) {
        return serviceProviderRepository.findByLicenseNumber(licenseNumber).orElse(null);
    }


    // create ---
    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider, boolean isServiceOriginated) {
        return createUser(serviceProvider, serviceProviderRepository, isServiceOriginated);
    }

    public ServiceProvider createServiceProvider(String firstName, String lastName, String emailAddress, String gender, String password, String language, String phoneNumber, String nif, String licenseNumber, long categoryId) {
        ServiceProvider serviceProvider = findByFirstName(firstName);

        if (serviceProvider == null) {
            Email email = findOrCreateEmail(emailAddress);
            Language userLanguage = findOrCreateLanguage(language);
            PhoneNumber userPhoneNumber = findOrCreatePhoneNumber(phoneNumber);

            serviceProvider = new ServiceProvider(
                    firstName,
                    lastName,
                    email,
                    gender,
                    password,
                    userLanguage,
                    userPhoneNumber,
                    nif,
                    licenseNumber,
                    categoryId
            );

            serviceProvider = createServiceProvider(serviceProvider, true);
        }

        return serviceProvider;
    }


    // update ---
    public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) {
        if (serviceProvider == null)
            return null;

        ServiceProvider existing = updateUser(serviceProvider, serviceProviderRepository);

        if (existing != null) {
            if (!existing.licenseNumber.equalsIgnoreCase(serviceProvider.licenseNumber))
                existing.licenseNumber = serviceProvider.licenseNumber;

            if (existing.categoryId != serviceProvider.categoryId)
                existing.categoryId = serviceProvider.categoryId;
        }

        return existing;
    }
}
