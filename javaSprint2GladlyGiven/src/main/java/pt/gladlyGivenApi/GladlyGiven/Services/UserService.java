package pt.gladlyGivenApi.GladlyGiven.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.Refugee;
import pt.gladlyGivenApi.GladlyGiven.Repositories.Users.RefugeeRepository;
import pt.gladlyGivenApi.GladlyGiven.CustomUtils;

@Service
public class UserService {

    @Autowired
    RefugeeRepository refugeeRepository;

    // Refugee
    // ---------------------------------------------------------------------
    public Refugee findRefugeeByFirstName(Long id) {
        Refugee refugee = (Refugee) refugeeRepository.findById(id).orElse(null);
        return refugee;
    }

    public Refugee findRefugeeByFirstName(String name) {
        Refugee refugee = (Refugee) refugeeRepository.findRefugeeByFirstName(name).orElse(null);
        return refugee;
    }

    public Refugee findRefugeeByLastName(String lastName) {
        Refugee refugee = (Refugee) refugeeRepository.findRefugeeByLastName(lastName).orElse(null);
        return refugee;
    }

    public Refugee createRefugee(String firstName, String lastName, String email, String gender, String password, String protocolId, String snsNumber, String nationality, String country) {
        Refugee refugee = findRefugeeByFirstName(firstName);

        if (refugee == null) {
            refugee = new Refugee(firstName, lastName, email, gender, password, protocolId, snsNumber, nationality, country);
            refugee = refugeeRepository.save(refugee);

            refugee.creationDate = CustomUtils.getDateAsString();
        }

        return refugee;
    }
}
