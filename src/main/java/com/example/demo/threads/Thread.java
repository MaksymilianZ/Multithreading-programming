package com.example.demo.threads;

import com.example.demo.service.ClassWithSynchronizeMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Maksymilian on 2017-06-03.
 */

@Component
public class Thread implements Runnable {

    private ClassWithSynchronizeMethod classWithSynchronizeMethod;

    @Autowired
    public Thread(ClassWithSynchronizeMethod classWithSynchronizeMethod) {
        this.classWithSynchronizeMethod = classWithSynchronizeMethod;

    }

    @Override
    public synchronized void run() {
        classWithSynchronizeMethod.getData();
    }
}