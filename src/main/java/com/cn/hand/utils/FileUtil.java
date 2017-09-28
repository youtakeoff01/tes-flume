package com.cn.hand.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by hand on 2017/9/6.
 */
public class FileUtil {

    /**
     * 判断文件是否存在
     * @param fileName
     * @return
     * @throws IOException
     */
    public static File fileExists(String fileName) throws IOException {
        File file;
        try {
            file = new File(fileName);
            if (!file.exists()) {
                File fileParent = file.getParentFile();
                if (!fileParent.exists()) {
                    System.out.println("目录不存在，创建" + fileParent);
                    fileParent.mkdirs();
                }
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new IOException("create file error:");
        }
        return file;
    }
}
