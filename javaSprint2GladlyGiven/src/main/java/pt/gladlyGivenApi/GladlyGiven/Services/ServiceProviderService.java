package pt.gladlyGivenApi.GladlyGiven.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.gladlyGivenApi.GladlyGiven.PageUtils;
import pt.gladlyGivenApi.GladlyGiven.Models.Availability;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.ServiceProvider;
import pt.gladlyGivenApi.GladlyGiven.Repositories.AvailabilityRepository;
import pt.gladlyGivenApi.GladlyGiven.Repositories.Users.ServiceProviderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProviderService extends AppUserService {

    // Repositories
    // ---------------------------------------------------------------------
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;



    // Service Provider
    // ---------------------------------------------------------------------
    // find ---
    public ServiceProvider findServiceProviderById(Long id) {
        return findUserById(id, serviceProviderRepository);
    }

    public ServiceProvider findServiceProviderByEmail(String email) {
        return findUserByEmail(email, serviceProviderRepository);
    }

    public ServiceProvider findServiceProviderByFirstName(String firstName) {
        return findUserByFirstName(firstName, serviceProviderRepository);
    }

    public ServiceProvider findServiceProviderByLastName(String lastName) {
        return findUserByLastName(lastName, serviceProviderRepository);
    }

    public ServiceProvider findServiceProviderByLicenseNumber(String licenseNumber) {
        return serviceProviderRepository.findByLicenseNumber(licenseNumber).orElse(null);
    }


    // create ---
    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider, boolean isServiceOriginated) {
        return createUser(serviceProvider, serviceProviderRepository, isServiceOriginated);
    }

    public ServiceProvider createServiceProvider(String firstName, String lastName, String emailAddress, String gender, String password, String language, String phoneNumber, String nif, String licenseNumber, long categoryId) {
        ServiceProvider serviceProvider = findServiceProviderByFirstName(firstName);

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

    public ServiceProvider addServicesToServiceProvider(Long serviceProviderId, List<Long> serviceIds) {
        ServiceProvider serviceProvider = findServiceProviderById(serviceProviderId);

        if (serviceProvider != null) {
            if (serviceProvider.serviceIds == null)
                serviceProvider.serviceIds = new ArrayList<>();

            for (Long serviceId : serviceIds) {
                if (!serviceProvider.serviceIds.contains(serviceId)) {
                    serviceProvider.serviceIds.add(serviceId);
                }
            }

            serviceProvider = serviceProviderRepository.save(serviceProvider);
        }

        return serviceProvider;
    }



    // Service Provider Availability
    // ---------------------------------------------------------------------
    public Availability findAvailability(Long id) {
        return availabilityRepository.findById(id).orElse(null);
    }

    public List<Availability> findAvailability(int pageNumber, int pageSize, String startDateTimeString) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("availability.startDateTimeString"));
        Page<Availability> page = availabilityRepository.findByStartDateTime(startDateTimeString, pageable);

        return PageUtils.pageToList(page);
    }

    public Availability createAvailability(Long serviceProviderId, String startDateTimeString, String endDateTimeString) {
        return null; // TODO
    }





    // Service Reviews
    // ---------------------------------------------------------------------
    private ServiceProvider addServiceReview(ServiceProvider serviceProvider, Long reviewId) {
        if (serviceProvider != null) {
            if (serviceProvider.reviewIds == null)
                serviceProvider.reviewIds = new ArrayList<>();

            if (!serviceProvider.reviewIds.contains(reviewId)) {
                serviceProvider.reviewIds.add(reviewId);
                serviceProvider = serviceProviderRepository.save(serviceProvider);
            }
        }

        return serviceProvider;
    }

    public ServiceProvider addServiceReview(Long serviceProviderId, Long reviewId) {
        ServiceProvider serviceProvider = findServiceProviderById(serviceProviderId);
        return addServiceReview(serviceProvider, reviewId);
    }

    public ServiceProvider addServiceReview(String serviceProviderlicenseNumber, Long reviewId) {
        ServiceProvider serviceProvider = findServiceProviderByLicenseNumber(serviceProviderlicenseNumber);
        return addServiceReview(serviceProvider, reviewId);
    }
}
