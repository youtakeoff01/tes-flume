import com.cn.hand.utils.AddressUtil;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by caisl2 on 2017/9/7.
 */
public class Test1 {
    private static final Logger logger = LoggerFactory.getLogger(Test1.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private static String fileAddress = "//catl-ri-lab/ri-lab/CommonData/TempdData/TES Testing/flume";
    public static void main(String[] args) {
      /*  NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "TDS-ADMIN", "Aa123456");
        try {
            SmbFile smbFile = new SmbFile("smb:" + fileAddress+"/tes/df/dfd/fwe/tett.txt", auth);
            try {
                smbFile.mkdirs();
            } catch (SmbException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(sdf.format(calendar.getTime()));
    }
}
