package com.cn.hand.timer;

import com.cn.hand.utils.AddressUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class QuartzJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(QuartzJob.class);
    public static boolean isRunning = false;
    public QuartzJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        //执行文件压缩任务
        TextCompression.execute();
        logger.info("SimpleQuartzJob - executing its JOB at "
                + new Date() + " in thread:" + Thread.currentThread().getName());
    }

    public static void runJob() {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 * * ?"))
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?"))    //每天凌晨执行一次
                    .startNow()
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

            //更新任务状态
            isRunning = true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            isRunning = false;
        }
    }

  /*  public static void main(String[] args) {
        runJob();
    }*/
}
