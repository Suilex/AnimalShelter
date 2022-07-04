package demo.animalshelter.controller.rest;

import demo.animalshelter.entity.Animal;
import demo.animalshelter.entity.AnimalType;
import demo.animalshelter.repository.AnimalTypeRepo;
import demo.animalshelter.service.AnimalTypeService;
import demo.animalshelter.service.model.AnimalTypeValid;
import demo.animalshelter.service.model.AnimalValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("rest")
public class RestAnimalTypeController {
    @Autowired
    AnimalTypeService animalTypeService;

    @PostMapping(path = "/add_type")
    public String addAnimalType(@ModelAttribute AnimalType animalType) {
        if (AnimalTypeValid.getValid(animalType, animalTypeService.getAll().stream().map(AnimalType::getId).collect(Collectors.toList()))){
            animalTypeService.add(animalType);
            return "ОК";
        }
        return "Ошибка";
    }

    @GetMapping("/delete_type/{id}")
    public String deleteAnimalType(@PathVariable long id) {
        if (animalTypeService.delete(id)) return "ОК";
        return "Обьекта не существует";
    }
}
