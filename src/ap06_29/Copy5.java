package ap06_29;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Scanner;

public class Copy5 {
    void f2fCopy(File from,File to,Arguments arguments){
        assert from.exists() && from.isFile();
        assert !to.exists() || to.isFile();

        if(shouldCopy(arguments,from,to)) {

            try {
                FileOutputStream fos = new FileOutputStream(to);
                if (arguments.verbose) System.out.println(from + " -> " + to);
                Files.copy(from.toPath(), fos);
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    void f2dCopy(Arguments arguments,File directory,File ...files){
        assert directory.exists() && directory.isDirectory();

        for(File file : files){
            File to = directory.toPath().resolve(file.getName()).toFile();
            f2fCopy(file,to,arguments);
        }
    }

    boolean isToNewer(File from,File to){
        return new Date(from.lastModified()).before(new Date(to.lastModified()));
    }

    boolean shouldCopy(Arguments argument,File from,File to){
        if(to.exists() && to.isFile()){
            Boolean overwriteFlag = true;
            if(argument.update){
                if(isToNewer(from,to)) overwriteFlag = false;
            }
            if(overwriteFlag && argument.interactive && !isAnswerYes(to)){
                overwriteFlag = false;
            }
            return overwriteFlag;
        }
        return true;
    }


    boolean isAnswerYes(File to){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%sを上書きしますか?(y/n)",to);
        String read = scanner.nextLine().toLowerCase().trim();
        if(!( read.equals("y") || read.equals("n"))) return isAnswerYes(to);
        else return read.equals("y");
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
        new Copy5().run(args);
    }
}
