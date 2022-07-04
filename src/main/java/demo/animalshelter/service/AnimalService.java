package demo.animalshelter.service;

import demo.animalshelter.entity.Animal;
import demo.animalshelter.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepo animalRepo;

    public Boolean add(Animal animal) {
        if (animal.getAnimalType() != null) {
            animalRepo.save(animal);
            return true;
        }
        return false;
    }

    public Boolean delete(Long id) {
        if (animalRepo.findById(id).isPresent()) {
            animalRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void edit(Animal animal) {
        animalRepo.save(animal);
    }

    public List<Animal> getAll() {
        return (List<Animal>) animalRepo.findAll();
    }

    public Animal getById(Long id) {
        return animalRepo.findById(id).orElseGet(Animal::new);
    }

    public String getLast() {
        return animalRepo.findLast().getName();
    }
}
