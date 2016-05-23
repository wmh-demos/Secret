package me.wayne.android;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ApkTools {

    private static final int BUFFER = 8192;

    /**
     * unzip a APK file, return all file's name which store method is {@link java.util.zip.ZipEntry#STORED}
     *
     * @param fileName APK file name.
     * @param filePath unzip destination directory name.
     * @return all file's name which store method is {@link java.util.zip.ZipEntry#STORED}
     */
    public static List<String> unzipApk(String fileName, String filePath) throws IOException {
        checkDirectory(filePath);

        List<String> storedFiles = new ArrayList<String>();
        ZipFile zipFile = new ZipFile(fileName);
        Enumeration em = zipFile.entries();
        while (em.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) em.nextElement();
            if (entry.isDirectory()) {
                new File(fileName, entry.getName()).mkdirs();
                continue;
            }

            File file = new File(filePath + File.separator + entry.getName());
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            if (entry.getMethod() == ZipEntry.STORED) {
                //store all this files' name
                storedFiles.add(entry.getName());
            }

            BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER);

            byte[] buf = new byte[BUFFER];
            int len;
            while ((len = bis.read(buf, 0, BUFFER)) != -1) {
                fos.write(buf, 0, len);
            }

            bos.flush();
            bos.close();
            bis.close();
        }
        zipFile.close();
        return storedFiles;
    }

    public static boolean checkDirectory(String dir) {
        File file = new File(dir);

        deleteFile(file);

        if (!file.exists()) {
            file.mkdirs();
        }
        return true;
    }

    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return false;
        }

        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteFile(files[i]);
            }
        }

        file.delete();

        return true;
    }
}
