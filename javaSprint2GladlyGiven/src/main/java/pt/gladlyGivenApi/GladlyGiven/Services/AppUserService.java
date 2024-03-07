// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Services;


import org.springframework.beans.factory.annotation.Autowired;
import pt.gladlyGivenApi.GladlyGiven.DateTimeUtils;
import pt.gladlyGivenApi.GladlyGiven.Models.Email;
import pt.gladlyGivenApi.GladlyGiven.Models.PhoneNumber;
import pt.gladlyGivenApi.GladlyGiven.Models.Country;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.AppUser;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.ServiceProvider;
import pt.gladlyGivenApi.GladlyGiven.Repositories.CountryRepository;
import pt.gladlyGivenApi.GladlyGiven.Repositories.EmailRepository;
import pt.gladlyGivenApi.GladlyGiven.Repositories.LanguageRepository;
import pt.gladlyGivenApi.GladlyGiven.Repositories.PhoneNumberRepository;
import pt.gladlyGivenApi.GladlyGiven.Repositories.Users.AppUserRepository;

/**
 * Base class for all Service classes related to AppUsers and its child classes
 */
public abstract class AppUserService {

    // Repositories
    // ---------------------------------------------------------------------
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;



    // AppUser
    // - probably better ways to do this, but this one works great!
    // ---------------------------------------------------------------------
    protected <T extends AppUser> T addCreationDateToUser(T user) {
        user.creationDate = DateTimeUtils.getDateTimeNowAsString();
        return user;
    }

    protected <T extends AppUser> T findUserById(Long id, AppUserRepository<T> repository) {
        return repository.findById(id).orElse(null);
    }

    protected <T extends AppUser> T findUserByEmail(String email, AppUserRepository<T>  repository) {
        Email em = findOrCreateEmail(email);
        return repository.findByEmail(em).orElse(null);
    }

    protected <T extends AppUser> T findUserByEmail(Email email, AppUserRepository<T>  repository) {
        Email em = findOrCreateEmail(email.email);
        return repository.findByEmail(em).orElse(null);
    }

    protected <T extends AppUser> T findUserByFirstName(String firstName, AppUserRepository<T> repository) {
        return repository.findByFirstNameIgnoreCase(firstName).orElse(null);
    }

    protected <T extends AppUser> T findUserByLastName(String lastName, AppUserRepository<T> repository) {
        return repository.findByLastNameIgnoreCase(lastName).orElse(null);
    }


    protected <T extends AppUser> T findUserByDTO(T userDTO, AppUserRepository<T> repository) {
        T existing = null;

        if (existing == null && userDTO.id > 0)
            existing = findUserById(userDTO.id, repository);

        if (existing == null && userDTO.email != null && !userDTO.email.email.isEmpty())
            existing = findUserByEmail(userDTO.email, repository);

        if (existing == null && !userDTO.firstName.isEmpty())
            existing = findUserByFirstName(userDTO.firstName, repository);

        if (existing == null && !userDTO.lastName.isEmpty())
            existing = findUserByLastName(userDTO.lastName, repository);

        return existing;
    }


    protected <T extends AppUser> T createUser(T user, AppUserRepository<T> repository, boolean isServiceOriginated) {
        if (user == null)
            return null;

        T provider = null;

        // If the serviceProvider did not come from this service, try to find if it already exists
        if (!isServiceOriginated) {
            provider = findUserByDTO(user, repository);
        }

        if (provider == null) {
            provider = addCreationDateToUser(user);
            provider = repository.save(provider);
        }

        return provider;
    }


    protected <T extends AppUser> T updateUser(T user, AppUserRepository<T> repository) {
        if (user == null)
            return null;

        T existing = findUserById(user.id, repository);

        if (existing != null) {
            if (!existing.firstName.equalsIgnoreCase(user.firstName)) {
                existing.firstName = user.firstName;
            }

            if (!existing.lastName.equalsIgnoreCase(user.lastName)) {
                existing.lastName = user.lastName;
            }

            if (!existing.email.email.equalsIgnoreCase(user.email.email)) {
                existing.email = user.email;
            }

            if (!existing.gender.equalsIgnoreCase(user.gender)) {
                existing.gender = user.gender;
            }

            if (!existing.mainLanguage.language.equalsIgnoreCase(user.mainLanguage.language)) {
                existing.mainLanguage = user.mainLanguage;
            }

            if (!existing.mainPhoneNumber.number.equalsIgnoreCase(user.mainPhoneNumber.number)) {
                existing.mainPhoneNumber = user.mainPhoneNumber;
            }

            if (!existing.photoURL.equalsIgnoreCase(user.photoURL)) {
                existing.photoURL = user.photoURL;
            }

            existing = repository.save(existing);
        }

        return existing;
    }



    // Email
    // ---------------------------------------------------------------------
    public Email findEmailByEmail(String email) {
        return emailRepository.findById(email).orElse(null);
    }

    public Email findOrCreateEmail(String email) {
        Email mail = findEmailByEmail(email);

        if (mail == null) {
            mail = new Email(email);
            mail = emailRepository.save(mail);
        }

        return mail;
    }



    // Country
    // ---------------------------------------------------------------------
    public Country findCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public Country findCountryByLanguage(String language) {
        return countryRepository.findByCountryIgnoreCase(language).orElse(null);
    }

    public Country findOrCreateCountry(String country) {
        Country lang = findCountryByLanguage(country);

        if (lang == null) {
            lang = new Country(country);
            lang = countryRepository.save(lang);
        }

        return lang;
    }


    // Language
    // ---------------------------------------------------------------------
    public Language findLanguageById(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    public Language findLanguageByLanguage(String language) {
        return languageRepository.findByLanguageIgnoreCase(language).orElse(null);
    }

    public Language findOrCreateLanguage(String language) {
        Language lang = findLanguageByLanguage(language);

        if (lang == null) {
            lang = new Language(language);
            lang = languageRepository.save(lang);
        }

        return lang;
    }



    // Phone Number
    // ---------------------------------------------------------------------
    public PhoneNumber findPhoneNumberByNumber(String number) {
        return phoneNumberRepository.findByNumber(number).orElse(null);
    }

    public PhoneNumber findOrCreatePhoneNumber(String number) {
        PhoneNumber phoneNumber = findPhoneNumberByNumber(number);

        if (phoneNumber == null) {
            phoneNumber = new PhoneNumber(number);
            phoneNumber = phoneNumberRepository.save(phoneNumber);
        }

        return phoneNumber;
    }
}
