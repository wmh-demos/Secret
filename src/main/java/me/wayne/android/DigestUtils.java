package me.wayne.android;


import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Base64;

public class DigestUtils {

    public static String getSHA1(String filePath) {
        byte[] sha1 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("sha-1");
            FileInputStream in = new FileInputStream(filePath);
            int bytes;
            while ((bytes = in.read()) != -1) {
                md.update((byte) bytes);
            }
            in.close();
            byte[] result = md.digest();
            sha1 = Base64.getEncoder().encode(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("getSHA1 : " + sha1);
        return sha1 == null ? "" : new String(sha1);
    }
}
