package me.wayne;


import me.wayne.android.TestAndroid;
import me.wayne.sort.TestSort;


public class Main {

    public static void main(String[] args) {
        TestSort.sort();

        TestAndroid.test("app-release-shrinked.apk", "app-release-shrinked.apk_FILES");
    }
}
