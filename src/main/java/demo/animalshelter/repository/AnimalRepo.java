package demo.animalshelter.repository;

import demo.animalshelter.entity.Animal;
import demo.animalshelter.entity.AnimalType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT * FROM ANIMAL WHERE animal_Type = :id", nativeQuery = true)
    List<Animal> findAllByAnimalType(long id);

    @Query(value = "SELECT * FROM ANIMAL ORDER BY ID DESC LIMIT 1", nativeQuery = true)
    Animal findLast();
}
