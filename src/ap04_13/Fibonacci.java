package ap04_13;

/**
 * No.5
 */
public class Fibonacci {
    void run(String[] args){
        Integer number = 20;
        if(args.length != 0) number = new Integer(args[0]);
        Integer results[] = new Integer[2];
        results[0] = 1;
        results[1] = 1;
        System.out.print(results[0]+" ");
        System.out.print(results[1]+" ");
        for(Integer i=2;i<number;i++){
            Integer result = results[0] + results[1];
            System.out.print(result+" ");
            results[0] = results[1];
            results[1] = result;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.run(args);
    }
}
