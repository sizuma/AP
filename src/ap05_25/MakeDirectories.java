package ap05_25;

import java.io.File;

public class MakeDirectories {
    void run(String dirName){
        File f = new File(dirName);
        if(f.exists()){
            System.out.println(dirName+"is ready exists");
        }else{
            f.mkdirs();
        }
    }

    public static void main(String[] args){
        MakeDirectories md = new MakeDirectories();
        for(String arg : args) md.run(arg);
    }
}
