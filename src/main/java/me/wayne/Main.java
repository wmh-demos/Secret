package me.wayne;


import java.util.ArrayList;
import java.util.List;

import me.wayne.file.FileUtilsKt;

public class Main {

    public static void main(String[] args) {
        List<String> soTxtList = FileUtilsKt.readFileAndReadAsLine("/Users/wayne/Downloads/so.txt");

        List<String> currentVersion = FileUtilsKt.loadDirSubFileNames(
                "/Users/wayne/Downloads/apk/lib/armeabi");


        List<String> soTxtListCopy = new ArrayList<>(soTxtList);
        soTxtListCopy.removeAll(currentVersion);
        printList(soTxtListCopy);
    }

    private static void test1() {
        String dir1 =
                "/Users/wayne/Downloads/now_1.64.5"
                        + ".18-d6da12c1470ff27ba47c2cc85864c6bae33bfa13/lib/armeabi";
        List<String> subFileNames1 = FileUtilsKt.loadDirSubFileNames(dir1);

        String dir2 = "/Users/wayne/Downloads/apk/lib/armeabi";
        List<String> subFileNames2 = FileUtilsKt.loadDirSubFileNames(dir2);
//        for (String fileName : subFileNames1) {
//            subFileNames2.remove(fileName);
//        }
//        for (String fileName : subFileNames2) {
//            System.out.println(fileName);
//        }

        for (String fileName : subFileNames2) {
            subFileNames1.remove(fileName);
        }
        for (String fileName : subFileNames1) {
            System.out.println(fileName);
        }
    }

    private static void printList(List<String> list) {
        for (String fileName : list) {
            System.out.println(fileName);
        }
    }
}
