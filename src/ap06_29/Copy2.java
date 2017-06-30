package ap06_29;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Copy2 {
    void f2fCopy(File from,File to){
        assert from.exists() && from.isFile();
        assert !to.exists() || to.isFile();
        try {
            FileOutputStream fos = new FileOutputStream(to);
            Files.copy(from.toPath(), fos);
        }catch (IOException e){ e.printStackTrace(System.err); }
    }

    void f2dCopy(File directory,File ...files){
        assert directory.exists() && directory.isDirectory();

        for(File file : files){
            File to = directory.toPath().resolve(file.getName()).toFile();
            f2fCopy(file,to);
        }
    }

    void copy(File[] files){
        File last = files[files.length-1];
        if(files.length == 2 && last.isFile()) f2fCopy(files[0],files[1]);
        else if(last.exists() && last.isDirectory()) {
            File[] fromFiles = new File[files.length-1];
            for(int index=0;index < files.length-1;index++) fromFiles[index] = files[index];
            f2dCopy(last,fromFiles);
        }
    }

    void run(String[] args){
        if(args.length < 2) System.out.println("コマンドライン引数には，少なくとも，コピー元，コピー先を指定する必要があります．");
        else {
            File[] files = new File[args.length];
            for(int index=0;index < files.length;index++) files[index] = new File(args[index]);
            copy(files);
        }
    }
    public static void main(String[] args){
        new Copy2().run(args);
    }
}
