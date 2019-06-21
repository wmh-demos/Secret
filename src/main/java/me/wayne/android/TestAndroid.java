package wayne.android;

import java.io.IOException;

public class TestAndroid {

    public static void test(String fileName, String filePath) {
        try {
            ApkTools.unzipApk(fileName, filePath);
            DigestUtils.getSHA1("app-release-shrinked.apk");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
