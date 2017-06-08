package ap06_01;

import java.io.*;

public class Head {
    void run(int n, InputStream in) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        reader.lines().limit(n).forEach(System.out::println);

        reader.close();
    }

    public static void main(String[] args) throws IOException{
        if(args.length > 1){
            new Head().run(new Integer(args[0]),new FileInputStream(new File(args[1])));
        }else new Head().run(new Integer(args[0]),System.in);
    }
}
