package ap04_13;

/**
 * No.1
 */
public class HelloWorld2 {
    void run(String[] args){
        String name;
        if(args.length == 0) name = "World";
        else name = args[0];

        System.out.println("Hello, "+name);
    }
    public static void main(String[] args){
        HelloWorld2 helloWorld2 = new HelloWorld2();
        helloWorld2.run(args);
    }
}
