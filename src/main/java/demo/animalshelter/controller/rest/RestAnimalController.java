package demo.animalshelter.controller.rest;

import demo.animalshelter.entity.Animal;
import demo.animalshelter.service.AnimalService;
import demo.animalshelter.service.model.AnimalValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("rest")
public class RestAnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping(path = "/add")
    public String addAnimal(@ModelAttribute Animal animal) {
        if (AnimalValid.getValid(animal, animalService.getAll().stream().map(Animal::getId).collect(Collectors.toList()))){
            animalService.add(animal);
            return "ОК";
        }
        return "Ошибка";
    }


    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable long id) {
        if (animalService.delete(id)) return "ОК";
        return "Обьекта не существует";
    }


}
