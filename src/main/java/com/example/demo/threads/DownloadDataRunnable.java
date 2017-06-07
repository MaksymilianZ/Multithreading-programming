package com.example.demo.threads;

import com.example.demo.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Maksymilian on 2017-06-03.
 */

@Component
public class DownloadDataRunnable implements Runnable {

    private PersonRepository personRepository;

    @Autowired
    public DownloadDataRunnable(PersonRepository personRepository) {
        this.personRepository=personRepository;
    }

    private List<Person> synchronizedList = new ArrayList<>();

    @Override
    public  void run(){
        List<Person> persons = personRepository.findAll();
        synchronized (synchronizedList) {
            synchronizedList.clear();
            synchronizedList.addAll(persons);
        }
    }

    public Person getPerson() {
        synchronized(synchronizedList) {
            return synchronizedList.get(new Random().nextInt(synchronizedList.size()));
        }
    }
}
