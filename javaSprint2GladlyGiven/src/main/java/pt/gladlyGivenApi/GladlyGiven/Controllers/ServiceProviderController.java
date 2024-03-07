// Author: Tiago Barracha, Hugo Lopes
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.ServiceProvider;
import pt.gladlyGivenApi.GladlyGiven.Services.ServiceProviderService;

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
        return serviceProviderService.findById(id);
    }

    @GetMapping("/email")
    public ServiceProvider getServiceProviderByEmail(@RequestParam String email) {
        return serviceProviderService.findByEmail(email);
    }

    @GetMapping("/firstname")
    public ServiceProvider getServiceProviderByFirstName(@RequestParam String firstName) {
        return serviceProviderService.findByFirstName(firstName);
    }

    @GetMapping("/lastname")
    public ServiceProvider getServiceProviderByLastName(@RequestParam String lastName) {
        return serviceProviderService.findByLastName(lastName);
    }

    @GetMapping("/licensenumber")
    public ServiceProvider getServiceProviderByLicenseNumber(@RequestParam String licenseNumber) {
        return serviceProviderService.findByLicenseNumber(licenseNumber);
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
}
