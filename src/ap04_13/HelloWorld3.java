package ap04_13;

/**
 * No.2
 */
public class HelloWorld3 {
    void run(String[] args){
        if(args.length == 0){
            System.out.println("Hello, World");
        }else if(args[0].equals("World")){
            System.out.println("Hi, World");
        }else System.out.println("Hello, "+args[0]);
    }

    public static void main(String[] args){
        HelloWorld3 helloWorld3 = new HelloWorld3();
        helloWorld3.run(args);
    }
}
