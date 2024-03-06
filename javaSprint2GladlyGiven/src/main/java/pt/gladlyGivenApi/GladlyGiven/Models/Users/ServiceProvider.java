// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

import java.util.List;

public class ServiceProvider extends MonetaryUser<ServiceProvider> {

    public Long categoryId; // fetched from Entity Framework API

    public List<Long> servicesId; // fetched from Entity Framework API

    @Override
    public ServiceProvider toDTO() {
        return null;
    }
}
