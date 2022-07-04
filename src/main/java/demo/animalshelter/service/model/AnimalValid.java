package demo.animalshelter.service.model;

import demo.animalshelter.entity.Animal;

import java.util.List;

public class AnimalValid {

    public static Boolean getValid(Animal animal, List<Long> ids) {
        System.out.println(ids);
        if (animal.getAnimalType() == null) {
            return false;
        } else if (animal.getName() == null) {
            return false;
        }
        return true;
    }
}
