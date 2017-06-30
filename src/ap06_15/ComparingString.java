package ap06_15;

public class ComparingString {
    final String target = "KSU_AP";

    void run(String[] args){
        for(String arg : args)
            if(arg.equals(target)) System.out.println("渡された文字列は\""+target+"\"です");
            else System.out.println("渡された文字列は\""+target+"\"ではなく\""+arg+"\"です");
    }

    public static void main(String[] args){
        new ComparingString().run(args);
    }
}
