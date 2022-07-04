package demo.animalshelter.service;

import demo.animalshelter.entity.Animal;
import demo.animalshelter.entity.AnimalType;
import demo.animalshelter.repository.AnimalRepo;
import demo.animalshelter.repository.AnimalTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalTypeService {
    @Autowired
    AnimalTypeRepo animalTypeRepo;

    @Autowired
    AnimalRepo animalRepo;

    public void add(AnimalType animalType) {
        animalTypeRepo.save(animalType);
    }

    public Boolean delete(Long id) {
        if (animalTypeRepo.findById(id).isPresent()) {
            animalRepo.deleteAllById(animalRepo.findAllByAnimalType(id).stream().map(Animal::getId).collect(Collectors.toList()));
            animalTypeRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void edit(AnimalType animalType) {
        animalTypeRepo.save(animalType);
    }

    public List<AnimalType> getAll() {
        return (List<AnimalType>) animalTypeRepo.findAll();
    }

    public List<AnimalType> getAllExceptOneById(long id) {
        return animalTypeRepo.findAllExceptOneById(id);
    }

    public AnimalType getById(long id) {
        return animalTypeRepo.findById(id).orElseGet(AnimalType::new);
    }
}
