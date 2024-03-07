// Author: Tiago Barrach
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.gladlyGivenApi.GladlyGiven.Models.Availability;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.ServiceProvider;
import pt.gladlyGivenApi.GladlyGiven.Services.ServiceProviderService;

import java.util.List;

@RestController
@RequestMapping("/api/serviceProvider")
public class ServiceProviderController {

    // Services
    // --------------------------------------------------------------------------------------
    @Autowired
    private ServiceProviderService serviceProviderService;



    // Service Provider
    // --------------------------------------------------------------------------------------
    @GetMapping("/id")
    public ServiceProvider getServiceProvider(@RequestParam Long id) {
        return serviceProviderService.findServiceProviderById(id);
    }

    @GetMapping("/email")
    public ServiceProvider getServiceProviderByEmail(@RequestParam String email) {
        return serviceProviderService.findServiceProviderByEmail(email);
    }

    @GetMapping("/firstname")
    public ServiceProvider getServiceProviderByFirstName(@RequestParam String firstName) {
        return serviceProviderService.findServiceProviderByFirstName(firstName);
    }

    @GetMapping("/lastname")
    public ServiceProvider getServiceProviderByLastName(@RequestParam String lastName) {
        return serviceProviderService.findServiceProviderByLastName(lastName);
    }

    @GetMapping("/licensenumber")
    public ServiceProvider getServiceProviderByLicenseNumber(@RequestParam String licenseNumber) {
        return serviceProviderService.findServiceProviderByLicenseNumber(licenseNumber);
    }

    @PostMapping("/fromParams")
    public ServiceProvider createServiceProviderViaRequestParams(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String gender, @RequestParam String password, @RequestParam String language, @RequestParam String phoneNumber, @RequestParam String nif, @RequestParam String licenseNumber, @RequestParam long categoryId) {
        return serviceProviderService.createServiceProvider(
                firstName,
                lastName,
                email,
                gender,
                password,
                language,
                phoneNumber,
                nif,
                licenseNumber,
                categoryId
        );
    }

    @PostMapping("/fromBody")
    public ServiceProvider createServiceProviderViaRequestBody(@RequestBody ServiceProvider serviceProvider) {
        return serviceProviderService.createServiceProvider(serviceProvider, false);
    }

    @PutMapping
    public ServiceProvider updateServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        return serviceProviderService.updateServiceProvider(serviceProvider);
    }

    @PutMapping("/addServices")
    public ServiceProvider addServicesToServiceProvider(@RequestParam Long serviceProviderId, @RequestBody List<Long> serviceIds) {
        return serviceProviderService.addServicesToServiceProvider(serviceProviderId, serviceIds);
    }



    // Service Provider Availability
    // --------------------------------------------------------------------------------------
    @PostMapping("/availability/add")
    public Availability createAvailability(@RequestParam Long serviceProviderId, @RequestBody Availability availability) {
        return null; // TODO
    }



    // Service Reviews
    // --------------------------------------------------------------------------------------
    @PostMapping("/review/id")
    public ServiceProvider addServiceReview(@RequestParam Long serviceProviderId, @RequestParam Long reviewId) {
        return serviceProviderService.addServiceReview(serviceProviderId, reviewId);
    }

    @PostMapping("/review/licensenumber")
    public ServiceProvider addServiceReview(@RequestParam String licenseNumber, @RequestParam Long reviewId) {
        return serviceProviderService.addServiceReview(licenseNumber, reviewId);
    }

    @PutMapping("/review/average")
    public ServiceProvider calculateServiceProviderReviewAverage(@RequestParam Long serviceProviderId, @RequestParam float average) {
        // TODO - link something with Entity Framework
        return null;
    }
}
