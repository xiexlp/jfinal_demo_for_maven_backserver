package com.js.isearch.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskTest {


    public static void main(String[] args) {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);//启用2个线程

        Task2 t1 = new Task2();
        // 马上运行，任务消耗3秒。运行结束后等待2秒。【有空余线程时】，再次运行该任务
        pool.scheduleWithFixedDelay(t1, 0, 2, TimeUnit.SECONDS);

        // 马上运行，任务消耗5秒，运行结束后等待2秒。【有空余线程时】，再次运行该任务
        Task2 t2 = new Task2();
        pool.scheduleWithFixedDelay(t2, 0, 2, TimeUnit.SECONDS);

    }
}
