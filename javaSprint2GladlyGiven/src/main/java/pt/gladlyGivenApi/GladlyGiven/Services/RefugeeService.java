// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.Refugee;
import pt.gladlyGivenApi.GladlyGiven.Repositories.Users.*;

@Service
public class RefugeeService extends AppUserService {

    // Repositories
    // ---------------------------------------------------------------------
    @Autowired
    private RefugeeRepository refugeeRepository;



    // Refugee
    // ---------------------------------------------------------------------
    // find ---
    public Refugee findRefugeeById(Long id) {
        return findUserById(id, refugeeRepository);
    }

    public Refugee findRefugeeByEmail(String email) {
        return findUserByEmail(email, refugeeRepository);
    }

    public Refugee findRefugeeByFirstName(String name) {
        return findUserByFirstName(name, refugeeRepository);
    }

    public Refugee findRefugeeByLastName(String lastName) {
        return findUserByLastName(lastName, refugeeRepository);
    }

    private Refugee findRefugeeViaDTO(Refugee refugee) {
        Refugee ref = null;

        if (!refugee.firstName.isEmpty())
            ref = findRefugeeByFirstName(refugee.firstName);

        if (ref == null && !refugee.lastName.isEmpty())
            ref = findRefugeeByLastName(refugee.lastName);

        return ref;
    }


    // create ---
    // does the refugee come from this service?
    public Refugee createRefugee(Refugee refugee, boolean isServiceOriginated) {
        if (refugee == null)
            return null;

        Refugee ref = null;

        // if didn't come from service, try to find if it already exists
        if (!isServiceOriginated) {
            ref = findRefugeeViaDTO(refugee);
        }

        if (ref == null) {
            ref = addCreationDateToUser(refugee);
            ref = refugeeRepository.save(ref);
        }

        return ref;
    }

    // create refugee with language & phone number
    public Refugee createRefugee(String firstName, String lastName, String emailAddress, String gender, String password, String protocolId, String snsNumber, String nationality, String country, String language, String phoneNumber) {
        Refugee refugee = findRefugeeByFirstName(firstName);

        if (refugee == null) {
            Email email = findOrCreateEmail(emailAddress);
            refugee = new Refugee(firstName, lastName, email, gender, password, protocolId, snsNumber, nationality);

            refugee.country = findOrCreateCountry(country);
            refugee.mainLanguage = findOrCreateLanguage(language);
            refugee.mainPhoneNumber = findOrCreatePhoneNumber(phoneNumber);

            refugee = createRefugee(refugee, true);
        }

        return refugee;
    }


    // update ---
    public Refugee updateRefugee(Refugee refugee) {
        if (refugee == null)
            return null;

        Refugee existing = updateUser(refugee, refugeeRepository);

        if (existing != null) {
            if (!existing.protocolId.equalsIgnoreCase(refugee.protocolId))
                existing.protocolId = refugee.protocolId;

            if (!existing.snsNumber.equalsIgnoreCase(refugee.snsNumber))
                existing.snsNumber = refugee.snsNumber;

            if (!existing.nationality.equalsIgnoreCase(refugee.nationality))
                existing.nationality = refugee.nationality;

            if (!existing.country.country.equalsIgnoreCase(refugee.country.country))
                existing.country = refugee.country;
        }

        return existing;
    }
}
