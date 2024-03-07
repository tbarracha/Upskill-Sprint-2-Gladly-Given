// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;

import java.util.List;

@Entity
public class ServiceProvider extends MonetaryUser<ServiceProvider> {

    @Column(unique = true)
    @Max(16)
    public String licenseNumber;

    public Long categoryId; // fetched from Entity Framework API

    public List<Long> serviceIds; // fetched from Entity Framework API

    public List<Long> reviewIds; // fetched from Entity Framework API

    @Min(0)
    public float reviewAverage; // fetched from Entity Framework API reviewObject

    public ServiceProvider() {
    }

    public ServiceProvider(String firstName, String lastName, Email email, String gender, String password, Language language, PhoneNumber phoneNumber, String nif, String licenseNumber, long categoryId) {
        super(firstName, lastName, email, gender, password, language, phoneNumber, nif);
        this.licenseNumber = licenseNumber;
        this.categoryId = categoryId;
    }

    public float calculateReviewAverage() {
        return 0;
    }

    @Override
    public ServiceProvider toDTO() {
        return null;
    }
}
