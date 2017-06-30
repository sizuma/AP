package ap06_08;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ZipCode {

    String stripQuate(String str){
        return str.substring(1,str.length()-1);
    }
    Map<String,String> getZipMap(InputStreamReader reader) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(reader);
        Map<String,String> result = new HashMap<>();
        bufferedReader.lines().map(s -> s.split(",")).forEach(columns -> {
            String zip = stripQuate(columns[2]);
            String name = stripQuate(columns[7]) + stripQuate(columns[8]);
            result.put(zip,name);
        });
        reader.close();
        return result;
    }

    void run(String zip) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/zipcode.csv"), Charset.forName("Shift-JIS"));
        Map<String,String> zips = getZipMap(inputStreamReader);
        if(zips.containsKey(zip)) System.out.println(zip+" : "+zips.get(zip));
        else System.out.println(zip+" : not found");
    }

    public static void main(String[] args) throws IOException{
        ZipCode code = new ZipCode();
        for(String arg : args) code.run(arg);
    }
}
