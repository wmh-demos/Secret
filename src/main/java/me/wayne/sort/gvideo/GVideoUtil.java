package me.wayne.sort.gvideo;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GVideoUtil {

    class Bdata {
        int status;
        String msg;
        Bdata.Ret ret;

        class Ret {

            List<Bdata.Ret.Data> data = new ArrayList<>();

            class Data {
                String date;
                int crashNum;
                int crashUser;
                int accessNum;
                int accessUser;
            }
        }
    }

    public static void main(String[] args) {
        String data = readLineByLineJava8("json.txt");
        if (data.isEmpty()) {
            return;
        }
        Bdata bdata = new Gson().fromJson(data, Bdata.class);
        System.out.println("status:" + bdata.status);

        List<Bdata.Ret.Data> dataList = bdata.ret.data;
        for (Bdata.Ret.Data data1 : dataList) {
            System.out.println(data1.crashUser * 1.0 * 100 / data1.accessUser);
        }
    }

    private static String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
