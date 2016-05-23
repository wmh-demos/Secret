package me.wayne.android;

import java.io.IOException;

public class TestAndroid {

    public static void test(String fileName, String filePath) {
        try {
            ApkTools.unzipApk(fileName, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
