package com.lujieni.async.controller;

import com.lujieni.async.service.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @Auther lujieni
 * @Date 2020/5/20
 */
@RestController
public class AsyncTaskController {
    @Autowired
    private AsyncTask asyncTask;

    /**
     * task1和task2这2个都是异步的方法因为加了@Async标签,
     * 那我们该如何得到结果呢?通过f1.isDone即可等待异步
     * 方法调用完成,这里是阻塞的!!!
     * @return
     * @throws Exception
     */
    @GetMapping("/do")
    public String doTask() throws Exception{
        long start = System.currentTimeMillis();
        Future<Boolean> f1 = asyncTask.task1();//异步方法
        Future<Boolean> f2 = asyncTask.task2();//异步方法
        while (!f1.isDone() || !f2.isDone()){
            if(f1.isDone() && f2.isDone()){
                System.out.println("f1:"+f1.get());
                System.out.println("f2:"+f2.get());
                break;
            }
        }
        //asyncTask.task2();
        long end = System.currentTimeMillis();
        return "task任务总耗时:"+(end-start)+"ms";
    }


}
