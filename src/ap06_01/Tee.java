package ap06_01;

import java.io.*;

public class Tee {
    void run(String outputFileName) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputFileName),true);

        reader.lines().forEach(s -> {
            System.out.println(s);
            writer.println(s);
        });
        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException{
        new Tee().run(args[0]);
    }
}
