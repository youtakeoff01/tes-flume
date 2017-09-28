package com.cn.hand.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hand on 2017/9/4.
 */
public class WriteLog {
    private static final Logger logger = LoggerFactory.getLogger(WriteLog.class);

    /**
     * @param args
     * @throws InterruptedException
     */
   /* public static void main(String[] args) throws InterruptedException {
//        while (true) {
        logger.info(Dates.str);
//            PV pv = JacksonUtil.jsonToBean(Dates.str, PV.class);
        KafkaProducer.producer(Dates.str, 10);
//        Thread.sleep(6000);
//        }
    }*/
}
