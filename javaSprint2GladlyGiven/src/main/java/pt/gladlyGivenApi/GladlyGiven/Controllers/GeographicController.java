// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.gladlyGivenApi.GladlyGiven.Models.Country;
import pt.gladlyGivenApi.GladlyGiven.Models.Language;
import pt.gladlyGivenApi.GladlyGiven.Repositories.CountryRepository;
import pt.gladlyGivenApi.GladlyGiven.Repositories.LanguageRepository;

import java.util.List;

@RestController
@RequestMapping("/api/geo")
public class GeographicController {

    // Repositories
    // --------------------------------------------------------------------------------------
    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CountryRepository countryRepository;



    // Language
    // --------------------------------------------------------------------------------------
    @GetMapping("/language/id")
    public Language getLanguageById(@RequestParam Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @GetMapping("/language/param")
    public Language getLanguageByLanguage(@RequestParam String language) {
        return languageRepository.findByLanguageIgnoreCase(language).orElse(null);
    }

    @GetMapping("/language")
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }



    // Country
    // --------------------------------------------------------------------------------------
    @GetMapping("/country/id")
    public Country getCountryById(@RequestParam Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @GetMapping("/country/param")
    public Country getCountryByCountry(@RequestParam String country) {
        return countryRepository.findByCountryIgnoreCase(country).orElse(null);
    }

    @GetMapping("/country")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
