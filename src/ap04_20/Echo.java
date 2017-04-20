package ap04_20;

import java.util.Arrays;
public class Echo {

    boolean hasHelpOption(String[] args){
        return Arrays.stream(args).anyMatch(str -> str.equals("-h"));
    }
    boolean hasNewLineOption(String[] args){
        return Arrays.stream(args).anyMatch(str -> str.equals("-n"));
    }

    void run(String[] args){
        if(hasHelpOption(args)){
            System.out.println("java Echo [OPTIONS] <string...>");
            System.out.println("OPTIONS");
            System.out.println("    -h:このメッセージを表示して終了する．");
            System.out.println("    -n: 改行せずに出力する．");
            return;
        }
        Arrays.stream(args)
	        .filter(str -> !str.startsWith("-"))
	        .forEach(str -> System.out.print(str+" "));
        if(!hasNewLineOption(args)) System.out.println();
    }

    public static void main(String[] args){
        Echo echo = new Echo();
        echo.run(args);
    }
}
