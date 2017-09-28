package com.cn.hand.utils;

import com.cn.hand.timer.TextCompression;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by caisl2 on 2017/9/7.
 */
public class AddressUtil {
    private static final Logger logger = LoggerFactory.getLogger(AddressUtil.class);
    private static String fileAddress = "//catl-ri-lab/ri-lab/CommonData/TempdData/TES prd/TESDATA";
    public static SmbFile  getAddress(String outfile){
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "TDS-ADMIN", "Aa123456");
        SmbFile smbfile = null;
        //String outfileName = outfile.substring(outfile.lastIndexOf("/"));
        boolean flag = false;
        try {
            String outfileDict = outfile.substring(0,outfile.lastIndexOf("/"));
            SmbFile dict = new SmbFile("smb:" + fileAddress + outfileDict, auth);
            // 如果文件夹不存在则创建
            if (!dict.exists()) {
                dict.mkdirs();
            }
            smbfile = new SmbFile("smb:" + fileAddress  + outfile, auth);
            if (!smbfile.exists()){
                smbfile.createNewFile();
            }
          /*  String outfilecopy = outfile.substring(0,outfile.lastIndexOf("."));
            while (!flag) {
                smbfile = new SmbFile("smb:" + fileAddress + outfilecopy + ".gz", auth);
                if (!smbfile.exists()) {
                    smbfile.createNewFile();
                    flag =true;
                } else {
                    outfilecopy = StringUtils.join(outfilecopy,"0");
                    flag = false;
                }
            }*/
        }catch (Exception e){
            logger.error("get address error {}",e);
        }
        return smbfile;
    }
}
