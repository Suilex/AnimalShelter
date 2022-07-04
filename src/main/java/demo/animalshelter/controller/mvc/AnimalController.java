package demo.animalshelter.controller.mvc;

import demo.animalshelter.entity.Animal;
import demo.animalshelter.service.AnimalService;
import demo.animalshelter.service.AnimalTypeService;
import demo.animalshelter.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.PrintException;
import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    AnimalTypeService animalTypeService;

    @Autowired
    AnimalService animalService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("types", animalTypeService.getAll());
        List<Animal> animals = animalService.getAll();
        model.addAttribute("animals", animals);
        if (animals.size() > 0) {
            model.addAttribute("new_animal", animalService.getLast());
            model.addAttribute("flag", true);
        } else {
            model.addAttribute("flag", false);
        }
        return "index";
    }

    @GetMapping("/add")
    public String addAnimal(Model model) {
        model.addAttribute("types", animalTypeService.getAll());
        return "addAnimal";
    }

    @PostMapping("/add")
    public String addAnimal(@ModelAttribute("newAnimal") Animal animal) {
        if (animalService.add(animal)) {
            try {
                Printer.print("В приют поступило новое животное " + animal.getName());
            } catch (Exception e) {
                System.out.println("Работа с принтером осуществляется некорректно");
            }
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable long id) {
        animalService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editAnimal(@PathVariable long id, Model model) {
        model.addAttribute("animal", animalService.getById(id));
        model.addAttribute("types", animalTypeService.getAllExceptOneById(
                animalService.getById(id).getAnimalType().getId()));
        return "editAnimal";
    }

    @PostMapping("/edit/{id}")
    public String editAnimal(@ModelAttribute("animal") Animal animal) {
        animalService.edit(animal);
        return "redirect:/";
    }

}
