package demo.animalshelter.repository;

import demo.animalshelter.entity.AnimalType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalTypeRepo extends CrudRepository<AnimalType, Long> {
    @Query(value = "SELECT * FROM ANIMAL_TYPE WHERE id <> :id", nativeQuery = true)
    List<AnimalType> findAllExceptOneById(long id);
}
