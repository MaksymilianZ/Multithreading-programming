package com.example.demo.service;

import com.example.demo.Person;
import com.example.demo.threads.DownloadDataRunnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Maksymilian on 2017-06-06.
 */
@Component
public class ClassWithSynchronizeMethod {

    private DownloadDataRunnable downloadDataRunnable;

    @Autowired
    public ClassWithSynchronizeMethod(DownloadDataRunnable downloadDataRunnable) {
        this.downloadDataRunnable=downloadDataRunnable;
    }

    private List<Person> list;
    private Logger logger;

    public synchronized void getData() {
        list = new ArrayList<>(downloadDataRunnable.getBrands());
        Person randomPerson = list.get(new Random().nextInt(list.size()));
        logger = LogManager.getLogger(ClassWithSynchronizeMethod.class);
        logger.info(randomPerson.toString());
    }
}
