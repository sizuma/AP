package ap05_25;

import java.io.File;

public class Remover {

    void run(String arg){
        File target = new File(arg);
        File[] files = target.listFiles();
        if(files != null){
            for(File sub : files){
                if(sub.isDirectory()) run(sub.toPath().toAbsolutePath().toString());
                else sub.delete();
            }
        }
        target.delete();
    }


    public static void main(String[] args){
        Remover remover = new Remover();
        for(String arg : args) remover.run(arg);
    }
}
