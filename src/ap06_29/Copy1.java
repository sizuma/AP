package ap06_29;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Copy1 {
    void f2fCopy(File from,File to){
        assert from.exists() && from.isFile();
        assert !to.exists() || to.isFile();
        try {
            FileOutputStream fos = new FileOutputStream(to);
            Files.copy(from.toPath(), fos);
        }catch (IOException e){ e.printStackTrace(System.err); }
    }

    void run(String[] args){
        if(args.length < 2) System.out.println("コマンドライン引数には，少なくとも，コピー元，コピー先を指定する必要があります．");
        else f2fCopy(new File(args[0]),new File(args[1]));
    }
    public static void main(String[] args){
        new Copy1().run(args);
    }
}
