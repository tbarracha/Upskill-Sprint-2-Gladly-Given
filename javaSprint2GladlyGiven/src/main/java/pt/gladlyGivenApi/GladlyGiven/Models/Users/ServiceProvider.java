// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceProvider extends MonetaryUser<ServiceProvider, ServiceProviderDTO> {

    @Column(unique = true)
    @Max(16)
    public String licenseNumber;

    public Long categoryId; // fetched from Entity Framework API

    @ElementCollection
    public List<Long> serviceIds; // fetched from Entity Framework API

    @ElementCollection
    public List<Long> reviewIds; // fetched from Entity Framework API

    @Min(0)
    public float reviewAverage; // fetched from Entity Framework API reviewObject

    public ServiceProvider() {
        //this.reviewIds = new ArrayList<>();
        //this.serviceIds = new ArrayList<>();
    }

    public ServiceProvider(String firstName, String lastName, Email email, String gender, String password, Language language, PhoneNumber phoneNumber, String nif, String licenseNumber, long categoryId) {
        super(firstName, lastName, email, gender, password, language, phoneNumber, nif);
        this.licenseNumber = licenseNumber;
        this.categoryId = categoryId;

        //this.reviewIds = new ArrayList<>();
        //this.serviceIds = new ArrayList<>();
    }

    public ServiceProvider(String firstName, String lastName, Email email, String gender, String password, Language language, PhoneNumber phoneNumber, String nif, String licenseNumber, long categoryId, List<Long> serviceIds, List<Long> reviewIds) {
        super(firstName, lastName, email, gender, password, language, phoneNumber, nif);
        this.licenseNumber = licenseNumber;
        this.categoryId = categoryId;

        this.serviceIds = serviceIds;
        this.reviewIds = reviewIds;
    }

    @Override
    public ServiceProviderDTO toDTO() {
        return new ServiceProviderDTO(
                firstName,
                lastName,
                email.email,
                gender,
                photoURL,
                mainLanguage.language,
                mainPhoneNumber.number,
                licenseNumber,
                categoryId,
                serviceIds,
                reviewIds,
                reviewAverage
        );
    }
}
