// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import java.util.List;

public class ServiceProviderDTO extends AppUserDTO {
    public String licenseNumber;

    public Long categoryId; // fetched from Entity Framework API

    public List<Long> serviceIds; // fetched from Entity Framework API

    public List<Long> reviewIds; // fetched from Entity Framework API

    public float reviewAverage; // fetched from Entity Framework API reviewObject

    public ServiceProviderDTO(String firstName, String lastName, String email, String gender, String photoURL, String mainLanguage, String mainPhoneNumber, String licenseNumber, Long categoryId, List<Long> serviceIds, List<Long> reviewIds, float reviewAverage) {
        super(firstName, lastName, email, gender, photoURL, mainLanguage, mainPhoneNumber);
        this.licenseNumber = licenseNumber;
        this.categoryId = categoryId;
        this.serviceIds = serviceIds;
        this.reviewIds = reviewIds;
        this.reviewAverage = reviewAverage;
    }
}
