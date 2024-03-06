// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.gladlyGivenApi.GladlyGiven.Models.ExampleModel;
import pt.gladlyGivenApi.GladlyGiven.Services.ExampleModelService;

import java.util.List;

@RestController
@RequestMapping("api/v1/example")
public class ExampleController {
    @Autowired
    private ExampleModelService service;

    @GetMapping("/health")
    public String health() {
        return "Java Spring API is working fine!";
    }

    @GetMapping()
    public List<ExampleModel> getAllExampleModels() {
        var models = service.getAllExampleModels();

        if (models != null && models.size() > 0) {
            return models;
        }

        return null;
    }

    @PostMapping
    public ExampleModel createExampleModel(@RequestParam String name) {
        return service.createExampleModel(name);
    }
}