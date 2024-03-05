package pt.gladlyGivenApi.GladlyGiven.Example;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
        ExampleModel model = repository.findByName(name).orElse(null);

        if (model == null) {
            model = new ExampleModel(name);
            model = repository.save(model);
        }

        return model;
    }
}
