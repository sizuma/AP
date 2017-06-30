package ap06_15;

import java.io.*;

public class Sorter {
    void run(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        reader.lines().sorted().forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException{
        new Sorter().run(args[0]);
    }
}
