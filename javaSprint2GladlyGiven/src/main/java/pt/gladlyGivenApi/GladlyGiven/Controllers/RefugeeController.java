// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.Refugee;
import pt.gladlyGivenApi.GladlyGiven.Services.RefugeeService;

@RestController
@RequestMapping("/api/refugee")
public class RefugeeController {

    // Services
    // --------------------------------------------------------------------------------------
    @Autowired
    private RefugeeService refugeeService;



    // Refugee
    // --------------------------------------------------------------------------------------
    @GetMapping("/id")
    public Refugee getRefugee(@RequestParam Long id) {
        return refugeeService.findRefugeeById(id);
    }

    @GetMapping("/firstname")
    public Refugee getRefugeeByFirstName(@RequestParam String name) {
        return refugeeService.findRefugeeByFirstName(name);
    }

    @GetMapping("/lastname")
    public Refugee getRefugeeByLastName(@RequestParam String lastName) {
        return refugeeService.findRefugeeByLastName(lastName);
    }

    @GetMapping("/email")
    public Refugee getRefugeeByEmail(@RequestParam String email) {
        return refugeeService.findRefugeeByEmail(email);
    }


    @PostMapping("/fromParams")
    public Refugee createRefugeeViaRequestParams(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String gender, @RequestParam String password, @RequestParam String protocolId, @RequestParam String snsNumber, @RequestParam String nationality, @RequestParam String country, @RequestParam String language, @RequestParam String phoneNumber) {
        return refugeeService.createRefugee(firstName, lastName, email, gender, password, protocolId, snsNumber, nationality, country, language, phoneNumber);
    }

    @PostMapping("/fromBody")
    public Refugee createRefugeeViaRequestBody(@RequestBody Refugee refugee) {
        return refugeeService.createRefugee(refugee, false);
    }

    @PutMapping
    public Refugee updateRefugee(@RequestBody Refugee refugee) {
        return refugeeService.updateRefugee(refugee);
    }
}
