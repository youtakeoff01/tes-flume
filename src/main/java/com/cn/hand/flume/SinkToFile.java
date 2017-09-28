package com.cn.hand.flume;

/**
 * Created by hand on 2017/9/4.
 */

import com.alibaba.fastjson.JSONObject;
import com.cn.hand.bean.PVEntity;
import com.cn.hand.bean.SubChannelData;
import com.cn.hand.timer.QuartzJob;
import com.cn.hand.utils.FileUtil;
import com.cn.hand.utils.JsonUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.flume.*;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SinkToFile extends AbstractSink implements Configurable {
    private static final Logger logger = LoggerFactory.getLogger(SinkToFile.class);
    private static final String PROP_KEY_EMPPATH = "file.empPath";

    private String empPath;

    public void configure(Context context) {
        this.empPath = context.getString(PROP_KEY_EMPPATH);

        /**
         * 监控定时是否存活,否则启动定时
        */
        if(!QuartzJob.isRunning){
            QuartzJob.runJob();
        }
    }

    public Status process() throws EventDeliveryException {
        Channel channel = getChannel();
        Event event;
        FileOutputStream fos = null;
        Transaction txn = channel.getTransaction();
        try {
            txn.begin();
            while (true) {
                event = channel.take();
                if (event != null) {
                    break;
                }
            }
            String fileName = event.getHeaders().get("fileName");
            String filePath = event.getHeaders().get("filePath");

            fileName = empPath + "/" + filePath + "/" + fileName;
            logger.info("******fileName ：" + fileName);

            String res = new String(event.getBody());
            PVEntity pvEntity = JsonUtils.toObject(res, PVEntity.class);
            JSONObject jsonObject = JsonUtils.parseObject(res);
            int i = 0;// 来标注有多少子通道的。
            Map<String,String> maps = Maps.newHashMap();// 用来存放子通道信息
            while (true) {
                i++;
                String str = jsonObject.getString("pvSubChannelData" + i);
                if ("0".equals(str)) {
                    continue;
                }else if (StringUtils.isEmpty(str)){
                    break;
                }else{
                    maps.put("pvSubChannelData" + i,str);
                }
            }
            pvEntity.setPvSubChannelDataMap(maps);
            File file = FileUtil.fileExists(fileName);//不存在创建文件
            if (file.length() > 0) {
                res = pvEntity.toReString()+ "\r";
            } else {
                res = PVEntity.getElementString() + "\r" + pvEntity.toReString()+ "\r";//第一次写入
            }

            fos = new FileOutputStream(file, true);
            fos.write(res.getBytes());
            txn.commit();
            return Status.READY;
        } catch (Exception e) {
            txn.rollback();
            logger.error("process error!", e);
            return Status.BACKOFF;
        } finally {
            try {
                if (null != fos) {
                    fos.close();
                }
            } catch (Exception e) {
                logger.error("fos.close error!", e);
            }
            txn.close();
        }
    }
}