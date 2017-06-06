package com.example.demo.repository;

import com.example.demo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Maksymilian on 2017-06-02.
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
