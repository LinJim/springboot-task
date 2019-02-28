package com.springboot.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     *  second,minute,hour,day of month,moth,day of week.
     *  0 * * * * MON-FRI 周一到周五整秒启动 即每分钟0秒时
     */
    //@Scheduled(cron = "0 * * * * MON-FRI")
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")
    //@Scheduled(cron = "0-4 * * * * MON-FRI")
    @Scheduled(cron = "0/4 * * * * MON-FRI") //每4秒执行一次
    public void hello(){
        System.out.println("hello....");
    }

}
