package ap06_15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tail {

    void run(int n,String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<String> read = new ArrayList<>();
        reader.lines().forEach(read::add);
        if(read.size() < n) n = read.size();
        for(int i=read.size()-n;i<read.size();i++) System.out.println(read.get(i));
    }

    public static void main(String[] args) throws IOException{
        new Tail().run(new Integer(args[0]),args[1]);
    }
}
