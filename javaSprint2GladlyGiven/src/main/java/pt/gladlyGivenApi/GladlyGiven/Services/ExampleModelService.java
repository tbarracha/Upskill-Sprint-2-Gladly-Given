// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pt.gladlyGivenApi.GladlyGiven.Models.ExampleModel;
import pt.gladlyGivenApi.GladlyGiven.Repositories.ExampleModelRepository;

import java.util.List;

@Service
public class ExampleModelService {
    @Autowired
    private ExampleModelRepository repository;

    public List<ExampleModel> getAllExampleModels() {
        return repository.findAll();
    }

    public ExampleModel createExampleModel(String name) {

        // can also use option if prefered...
        ExampleModel model = repository.findByNameIgnoreCase(name).orElse(null);

        if (model == null) {
            model = new ExampleModel(name);
            model = repository.save(model);
        }

        return model;
    }
}
