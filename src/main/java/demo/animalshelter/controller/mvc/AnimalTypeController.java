package demo.animalshelter.controller.mvc;

import demo.animalshelter.entity.Animal;
import demo.animalshelter.entity.AnimalType;
import demo.animalshelter.service.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalTypeController {
    @Autowired
    AnimalTypeService animalTypeService;

    @GetMapping("/add_type")
    public String addAnimal(Model model) {
        return "addAnimalType";
    }

    @PostMapping("/add_type")
    public String addAnimal(@ModelAttribute("newAnimalType") AnimalType animalType) {
        System.out.println(animalType);
        animalTypeService.add(animalType);
        return "redirect:/";
    }

    @GetMapping("/delete_type/{id}")
    public String deleteAnimal(@PathVariable long id) {
        animalTypeService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit_type/{id}")
    public String editAnimal(@PathVariable long id, Model model) {
        model.addAttribute("type", animalTypeService.getById(id));
        return "editAnimalType";
    }

    @PostMapping("/edit_type/{id}")
    public String editAnimal(@ModelAttribute("animalType") AnimalType animalType) {
        animalTypeService.edit(animalType);
        return "redirect:/";
    }
}
