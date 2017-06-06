package com.example.demo.threads;

import com.example.demo.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksymilian on 2017-06-03.
 */

@Component
public class DownloadDataRunnable implements Runnable {

    private final PersonRepository personRepository;

    @Autowired
    public DownloadDataRunnable(PersonRepository personRepository) {
        this.personRepository=personRepository;
    }

    private List<Person> brands = new ArrayList<>();

    public List<Person> getBrands() {
        return brands;
    }

    @Override
    public  void run(){
        synchronized (brands) {
            List<Person> persons = personRepository.findAll();
            brands.addAll(persons);
        }
    }
}
