package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends CrudRepository<Person, Long> {
    @Query(
            "UPDATE Person AS p SET p.id = ?1, p.firstName = ?2 where p.id = ?3"
    )
    void updatePeopleById(Long newId, String newFirstName, Long oldId);
}
