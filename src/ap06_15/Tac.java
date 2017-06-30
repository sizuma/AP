package ap06_15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tac {

    void run(String file) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        List<String> buffer = new ArrayList<>();

        reader.lines().forEach(buffer::add);
        final int length = buffer.size();
        for(int i=length-1;i >= 0;i--) System.out.println(buffer.get(i));

    }

    public static void main(String[] args) throws IOException{
        new Tac().run(args[0]);
    }
}
