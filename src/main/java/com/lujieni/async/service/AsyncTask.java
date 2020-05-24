package com.lujieni.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Auther lujieni
 * @Date 2020/5/20
 */
@Service
public class AsyncTask {

    @Async
    public Future<Boolean> task1() throws InterruptedException{
        System.out.println("task1开始");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("task1任务耗时"+(end-start)+"ms");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> task2() throws InterruptedException{
        System.out.println("task2开始");
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("task2任务耗时"+(end-start)+"ms");
        return new AsyncResult<>(true);

    }

    @Async
    public Future<Boolean> task3() throws InterruptedException{
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("task3任务耗时"+(end-start)+"ms");
        return new AsyncResult<>(true);
    }

}
