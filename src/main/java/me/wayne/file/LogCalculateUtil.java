package wayne.file;

import com.sun.istack.internal.Nullable;

import java.io.*;
import java.text.DecimalFormat;

public class LogCalculateUtil {

    //SYSCPU
    private static final String APPCPURATE = "AppCPU";
    private static final String APPCPURATE_END = "%";

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void calculate() {
        File file = new File("../../../log/");
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("file.listFiles empty");
            return;
        }

        double totalCount = 0, totalRate = 0;

        for (File log : files) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(log));
                String line = br.readLine();
                while (line != null) {
                    if (line.contains(APPCPURATE) && line.contains(APPCPURATE_END)) {
                        int start = line.indexOf(APPCPURATE) + APPCPURATE.length() + 1;
                        int end = line.indexOf(APPCPURATE_END);
                        String rate = line.substring(start, end);
                        totalRate += Double.valueOf(rate);
                        totalCount++;
                    }
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(br);
            }
        }
        System.out.println("totalCount : " + totalCount + " rate : " + (totalCount == 0 ? 0 : df.format(totalRate / totalCount)));
    }

    private static void close(@Nullable Closeable target) {
        if (target != null) {
            try {
                target.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
