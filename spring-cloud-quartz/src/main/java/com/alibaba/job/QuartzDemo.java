package com.alibaba.job;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo {

    public static void main(String[] args){
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();

        try {
            Scheduler scheduler=schedulerFactory.getScheduler();
            //启动scheduler
            scheduler.start();
            //创建simpleJob的JobDetail实例，并设置name/group
            JobDetail jobDetail= JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("myJob","myJobGroup1")
                    //JobDataMap可以给任务传递参数
                    .usingJobData("job_param","job_param1")
                    .build();
            //创建trigger触发器设置使用cronSchedule方式调度
            Trigger trigger= TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger","myTriggerGroup1")
                    .usingJobData("job_trigger_param","job_trigger_param1")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ? "))
                    .build();
            //注册jobDetail实例到schedule以及使用对应的Trigger触发时机
            scheduler.scheduleJob(jobDetail,trigger);






        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
