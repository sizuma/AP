package ap06_01;

import java.io.*;

public class Grep {
    void run(String key,String targetFile) throws IOException{
        File file = new File(targetFile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        reader.lines().filter(s -> s.contains(key)).forEach(System.out::println);

        reader.close();
    }

    public static void main(String[] args) throws IOException{
        new Grep().run(args[0],args[1]);
    }
}
