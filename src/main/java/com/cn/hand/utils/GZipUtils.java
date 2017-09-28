package com.cn.hand.utils;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * GZIP工具
 *
 * @author
 * @since 0906
 */
public abstract class GZipUtils {

    private static final Logger logger = LoggerFactory.getLogger(GZipUtils.class);

    public static final int BUFFER = 1024;
    public static final String EXT = ".gz";

    /**
     * 文件压缩
     *
     * @param inFile
     * @param outFile
     * @param delete  是否删除原始文件
     * @throws IOException
     */
    public static void compress(File inFile, String outFile, boolean delete) throws IOException {

        FileInputStream fis = null;
        SmbFile address = null;
        SmbFileOutputStream fos = null;
        try {
            fis = new FileInputStream(inFile);
            //FileOutputStream fos = new FileOutputStream(outFile);
            address = AddressUtil.getAddress(outFile);
            logger.info("gzip adress : ",address);
            fos = new SmbFileOutputStream(address);
            compress(fis, fos);
        }catch (Exception e){
            logger.error("GZIP error",e);
        }
        if (fis !=null)
        fis.close();
        if (fos != null) {
            fos.flush();
            fos.close();
        }
        if (delete) {
            inFile.delete();
        }
    }

    /**
     * 数据压缩
     *
     * @param is
     * @param os
     * @throws IOException
     */
    public static void compress(InputStream is, OutputStream os)
            throws IOException {

        GZIPOutputStream gos = new GZIPOutputStream(os);

        int count;
        byte data[] = new byte[BUFFER];
        while ((count = is.read(data, 0, BUFFER)) != -1) {
            gos.write(data, 0, count);
        }
        gos.finish();
        gos.close();
    }

    /**
     * 文件解压缩
     *
     * @param inputFileName
     * @param outputFileName
     * @throws IOException
     */
    public static void decompress(String inputFileName, String outputFileName)
            throws IOException {
        FileInputStream inputFile = new FileInputStream(inputFileName);
        FileOutputStream outputFile = new FileOutputStream(outputFileName);
        decompress(inputFile, outputFile);
        inputFile.close();
        outputFile.flush();
        outputFile.close();
    }


    /**
     * 数据解压缩
     *
     * @param is
     * @param os
     * @throws IOException
     */
    public static void decompress(InputStream is, OutputStream os)
            throws IOException {

        GZIPInputStream gis = new GZIPInputStream(is);

        int count;
        byte data[] = new byte[BUFFER];
        while ((count = gis.read(data, 0, BUFFER)) != -1) {
            os.write(data, 0, count);
        }

        gis.close();
    }


}