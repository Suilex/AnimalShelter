package demo.animalshelter.service.model;

import demo.animalshelter.entity.AnimalType;

import java.util.List;

public class AnimalTypeValid {
    public static Boolean getValid(AnimalType animalType, List<Long> ids) {
        if (animalType.getName() == null) {
            return false;
        }
        return true;
    }
}
