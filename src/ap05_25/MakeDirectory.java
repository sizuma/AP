package ap05_25;

import java.io.File;

public class MakeDirectory {
    void run(String dirName){
        File f = new File(dirName);
        if(f.exists()){
            System.out.println(dirName+"is ready exists");
        }else if(!f.getParentFile().exists()){
            System.out.println(dirName+" could not make directory.");
        }else{
            f.mkdir();
        }
    }

    public static void main(String[] args){
        new MakeDirectory().run(args[0]);
    }
}
