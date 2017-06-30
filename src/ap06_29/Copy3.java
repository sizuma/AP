package ap06_29;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Copy3 {
    void f2fCopy(File from,File to,Arguments arguments){
        assert from.exists() && from.isFile();
        assert !to.exists() || to.isFile();
        try {
            FileOutputStream fos = new FileOutputStream(to);
            if(arguments.verbose) System.out.println(from+" -> "+to);
            Files.copy(from.toPath(), fos);
        }catch (IOException e){ e.printStackTrace(System.err); }
    }

    void f2dCopy(Arguments arguments,File directory,File ...files){
        assert directory.exists() && directory.isDirectory();

        for(File file : files){
            File to = directory.toPath().resolve(file.getName()).toFile();
            f2fCopy(file,to,arguments);
        }
    }

    void copy(File[] files,Arguments arguments){
        File last = files[files.length-1];
        if(files.length == 2 && last.isFile()) f2fCopy(files[0],files[1],arguments);
        else if(last.exists() && last.isDirectory()) {
            File[] fromFiles = new File[files.length-1];
            for(int index=0;index < files.length-1;index++) fromFiles[index] = files[index];
            f2dCopy(arguments,last,fromFiles);
        }
    }

    void printHelp(){
        System.out.print("OPTIONS\n");
        System.out.print("     -h: このメッセージを表示して終了する（help）．\n");
        System.out.print("     -i: コピー先のファイルが存在していた時，ユーザに上書き確認を求める（interactive）．\n");
        System.out.print("     -r: ディレクトリを再帰的にコピーする（recursive）．\n");
        System.out.print("     -u: コピー先のファイルが存在しない場合，もしくはコピー元のファイルの方が新しい場合のみコピーする（update）．\n");
        System.out.print("     -v: 実行内容を表示する（verbose）．\n");
    }

    void run(String[] args){
        Arguments arguments = new Arguments(args);
        if(arguments.help) printHelp();
        else if(args.length < 2) System.out.println("コマンドライン引数には，少なくとも，コピー元，コピー先を指定する必要があります．");
        else {
            File[] files = new File[arguments.args.length];
            for(int index=0;index < files.length;index++) files[index] = new File(arguments.args[index]);
            copy(files,arguments);
        }
    }
    public static void main(String[] args){
        new Copy3().run(args);
    }
}
