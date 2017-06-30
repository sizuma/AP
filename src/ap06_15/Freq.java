package ap06_15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Freq {

    void run(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        Map<String,Integer> counts = new HashMap<>();

        reader.lines().forEach(line -> {
            Arrays.stream(line.split(" ")).forEach(word -> {
                int n = counts.getOrDefault(word,0);
                n++;
                counts.put(word,n);
            });
        });
        counts.forEach( (word,count) -> {
            System.out.println(word + " : "+count);
        });
        reader.close();
    }

    public static void main(String[] args) throws IOException{
        new Freq().run(args[0]);
    }
}
