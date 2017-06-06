package com.example.demo.service;


import com.example.demo.threads.DownloadDataRunnable;
import com.example.demo.threads.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maksymilian on 2017-06-02.
 */

@Service
public class DataService {

    private final ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
    private final DownloadDataRunnable downloadDataRunnable;
    private final Thread thread;


    @Autowired
    public DataService(DownloadDataRunnable downloadDataRunnable, Thread thread) {
        this.downloadDataRunnable = downloadDataRunnable;
        this.thread = thread;
    }

    @PostConstruct
    public void setup() {

        threadPool.scheduleAtFixedRate(downloadDataRunnable,0,1, TimeUnit.SECONDS);
        threadPool.scheduleWithFixedDelay(thread,1,10,TimeUnit.SECONDS);
        threadPool.scheduleWithFixedDelay(thread,1,10,TimeUnit.SECONDS);
        threadPool.scheduleWithFixedDelay(thread,1,10,TimeUnit.SECONDS);

    }

}
