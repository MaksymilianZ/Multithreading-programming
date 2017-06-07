package com.example.demo.threads;

import com.example.demo.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Maksymilian on 2017-06-03.
 */

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Consumer implements Runnable {

    private DownloadDataRunnable downloadDataRunnable;
    private static final Logger logger = LogManager.getLogger(Consumer.class);

    @Autowired
    public Consumer(DownloadDataRunnable downloadDataRunnable) {
        this.downloadDataRunnable = downloadDataRunnable;
    }

    private List<Person> list = new ArrayList<>();

    @Override
    public void run() {
        Person person = downloadDataRunnable.getPerson();
        logger.info(person);
    }
}