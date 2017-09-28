package com.cn.hand.timer;

import com.cn.hand.utils.DateUtil;
import com.cn.hand.utils.FileUtil;
import com.cn.hand.utils.GZipUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hand on 2017/9/5.
 */
public class TextCompression {

    private static final Logger logger = LoggerFactory.getLogger(TextCompression.class);

    private static String EMP_PATHNAME = "/storage/flumedata/empdata";
    private static String DATA_PATHNAME = "/tesdatapro";
    private static String DATA_FILEPREFIX = ".gz";

    /**
     * 迭代指定目录全部内容
     */
    public static void execute() {
        File file = new File(EMP_PATHNAME);
        recursionProcessFile(file);
    }

    /**
     * 递归解析压缩文件到指定目录
     *
     * @param file
     */
    public static void recursionProcessFile(File file) {
        try {
            if (file != null && file.isDirectory()) {

                File[] fileArray = file.listFiles();

                if (fileArray != null && fileArray.length > 0) {

                    String inFileName;
                    String parentFileName;
                    String outFileName;
                    for (File f : fileArray) {
                        if (f.isFile() /*&& f.getPath().contains(DateUtil.getBeforeDay())*/) {

                            parentFileName = f.getParentFile().getName();
                            logger.info("inFile:" + f + "，parentFileName : " + parentFileName);

                            inFileName = f.getAbsolutePath();
                            outFileName = inFileName.replace(EMP_PATHNAME, DATA_PATHNAME).replace(parentFileName + "/", "")+ DATA_FILEPREFIX;
                            logger.info("outFileName:" + outFileName);

                            //File outfile = FileUtil.fileExists(outFileName);

                            GZipUtils.compress(f, outFileName , true);
                            //删除yyyyMMdd文件夹
                            f.getParentFile().delete();

                        } else {
                            recursionProcessFile(f);
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error("recursion error!", e);
        }
    }
}