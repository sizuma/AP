package ap06_01;

import java.io.*;
import java.util.function.Supplier;

public class Cat2 {

    Supplier<Integer> newIndexSupplier(){
        return new Supplier<Integer>() {
            private int index = 1;
            @Override
            public Integer get() {
                int result = index;
                index++;
                return result;
            }
        };
    }

    void run(String fileName) throws IOException{
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Supplier<Integer> index = newIndexSupplier();
        reader.lines().forEach(line -> {
            System.out.println(index.get()+" "+line);
        });
        reader.close();
    }

    public static void main(String[] args) throws IOException{
        Cat2 cat = new Cat2();
        for(String fileName : args){
            cat.run(fileName);
        }
    }
}
