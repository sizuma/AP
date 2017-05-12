package ap05_11;

public class Fibonacci2 {

    void run(String[] args){
        if(args.length > 0){
            for(String arg : args){
                System.out.println("fibonacci("+arg+") = "+getFibonacci(new Integer(arg)));
            }
        }else{
            System.out.println(getFibonacci(10));
        }
    }

    int getFibonacci(int index){
        if(index == 1 || index == 2) return 1;
        else return getFibonacci(index-1) + getFibonacci(index-2);
    }
    public static void main(String[] args){
        new Fibonacci2().run(args);
    }
}
