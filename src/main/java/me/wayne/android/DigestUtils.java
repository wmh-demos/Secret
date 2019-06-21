package wayne.android;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class DigestUtils {

    public static String getSHA1(String filePath) {
        String sha1 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("sha-1");
            FileInputStream in = new FileInputStream(filePath);
            int bytes;
            while ((bytes = in.read()) != -1) {
                md.update((byte) bytes);
            }
            in.close();
            byte[] result = md.digest();
            sha1 = Base64.encode(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("getSHA1 : " + sha1);
        return sha1;
    }
}
