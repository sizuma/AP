package ap06_15;

public class Yes {
    void run(String target){
        while(true)System.out.println(target);
    }

    public static void main(String[] args){
        if(args.length > 0) new Yes().run(args[0]);
        else new Yes().run("y");
    }
}
