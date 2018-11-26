

package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
    @Scheduled(initialDelay=2000,fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println(
          "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }
	@Scheduled(cron = "*/5 * * * * *")
    public void scheduleTaskUsingCronExpression() {
    long now = System.currentTimeMillis() / 1000;
    System.out.println("schedule tasks using cron jobs - " + now);
    }
}
