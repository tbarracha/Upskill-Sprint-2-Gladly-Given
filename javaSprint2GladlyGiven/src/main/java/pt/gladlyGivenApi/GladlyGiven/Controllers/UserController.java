package pt.gladlyGivenApi.GladlyGiven.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.gladlyGivenApi.GladlyGiven.Models.Users.Refugee;
import pt.gladlyGivenApi.GladlyGiven.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    // Refugee
    // --------------------------------------------------------------------------------------
    @GetMapping("/refugee/id")
    public Refugee getRefugee(@RequestParam Long id) {
        return userService.findRefugeeByFirstName(id);
    }

    @GetMapping("/refugee/firstname")
    public Refugee getRefugeeByFirstName(@RequestParam String name) {
        return userService.findRefugeeByFirstName(name);
    }

    @GetMapping("/refugee/lastname")
    public Refugee getRefugeeByLastName(@RequestParam String lastName) {
        return userService.findRefugeeByLastName(lastName);
    }

    @PostMapping("/refugee")
    public Refugee createRefugee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String gender, @RequestParam String password, @RequestParam String protocolId, @RequestParam String snsNumber, @RequestParam String nationality, @RequestParam String country) {
        return userService.createRefugee(firstName, lastName, email, gender, password, protocolId, snsNumber, nationality, country);
    }
}
