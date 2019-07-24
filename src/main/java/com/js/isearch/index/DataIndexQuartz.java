package com.js.isearch.index;

import java.util.Date;

import com.js.isearch.jobs.CoinMarketCapAllJob;
import com.js.isearch.jobs.MasterNodesOnlineJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a RAM Store Quartz!
 * @author dufy
 * @date 2017.02.04
 *
 */
public class DataIndexQuartz {

    private static Logger _log = LoggerFactory.getLogger(DataIndexQuartz.class);

    public static void main(String[] args) {
        try {
        	//索引的启动
            quartzJob();
            //数据爬虫
            masterNodesOnlineDataJob();
            //爬coin market
            coinMarketCapDataAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void quartzJob() throws SchedulerException {
        //1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();

        //3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(DataIndexJob.class)
                .withDescription("this is a ram job") //job的描述
                .withIdentity("ramJob", "ramGroup") //job 的name和group
                .build();

        //任务运行的时间，SimpleSchedle类型触发器有效
        long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动任务
        Date statTime = new Date(time);

        //4.创建Trigger
            //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                    .withDescription("")
                    .withIdentity("ramTrigger", "ramTriggerGroup")
                    //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                    .startAt(statTime)  //默认当前时间启动
                    //.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                    //.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 */20 * * * ?")) //每分钟执行一次
                    //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 * * *  ?")) //每个整点的0分执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 23 * * ?")) //每天23点整执行一次
                    .build();

        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);

        //6.启动 调度器
        scheduler.start();
        _log.info("启动时间 ： " + new Date());

    }


    public static void masterNodesOnlineDataJob() throws SchedulerException {
        //1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();

        //3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(MasterNodesOnlineJob.class)
                .withDescription("this is a ram job") //job的描述
                .withIdentity("masterNodesOnlineJob", "masterNodesOnlineJobGroup") //job 的name和group
                .build();

        //任务运行的时间，SimpleSchedle类型触发器有效
        long time=  System.currentTimeMillis() + 5*1000L; //3秒后启动任务
        Date statTime = new Date(time);

        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity("masterNodesTrigger", "masterNodesTriggerGroup")
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)  //默认当前时间启动
                //.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
               .withSchedule(CronScheduleBuilder.cronSchedule("0 */20 * * * ?")) //每分钟执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 * * *  ?")) //每个整点的0分执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 23 * * ?")) //每天23点整执行一次
                .build();

        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);

        //6.启动 调度器
        scheduler.start();
        _log.info("启动时间 ： " + new Date());

    }

    /***
     * 一次可以读取所有
     *  没五分钟执行一次
     * @throws SchedulerException
     */
    public static void coinMarketCapDataAllJob() throws SchedulerException {
        //1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();

        //3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(CoinMarketCapAllJob.class)
                .withDescription("this is a ram job") //job的描述
                .withIdentity("coinMarketCapDataAllJob", "coinMarketCapDataAllJobGroup") //job 的name和group
                .build();

        //任务运行的时间，SimpleSchedle类型触发器有效
        long time=  System.currentTimeMillis() + 5*1000L; //3秒后启动任务
        Date statTime = new Date(time);

        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity("coinMarketCapDataAllJobTrigger", "coinMarketCapDataAllJobTriggerGroup")
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)  //默认当前时间启动
                //.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .withSchedule(CronScheduleBuilder.cronSchedule("0 */5 * * * ?")) //每分钟执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 * * *  ?")) //每个整点的0分执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 23 * * ?")) //每天23点整执行一次
                .build();

        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);

        //6.启动 调度器
        scheduler.start();
        _log.info("启动时间 ： " + new Date());

    }


    /***
     * 每次只能读一页
     * @throws SchedulerException
     */
    public static void coinMarketCapDataJob() throws SchedulerException {
        //1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();

        //3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(MasterNodesOnlineJob.class)
                .withDescription("this is a ram job") //job的描述
                .withIdentity("coinMarketCapJob", "coinMarketCapJobGroup") //job 的name和group
                .build();

        //任务运行的时间，SimpleSchedle类型触发器有效
        long time=  System.currentTimeMillis() + 5*1000L; //3秒后启动任务
        Date statTime = new Date(time);

        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity("coinMarketCapTrigger", "coinMarketCapTriggerGroup")
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)  //默认当前时间启动
                //.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .withSchedule(CronScheduleBuilder.cronSchedule("0 */20 * * * ?")) //每分钟执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 * * *  ?")) //每个整点的0分执行一次
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 0 23 * * ?")) //每天23点整执行一次
                .build();

        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);

        //6.启动 调度器
        scheduler.start();
        _log.info("启动时间 ： " + new Date());

    }

}
