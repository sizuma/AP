package ap04_20;


import java.util.stream.IntStream;

/**
 * No.4
 */
public class MonteCarloPi {
    public static void main(String[] args){
        Integer n = 1000;
        if(args.length > 0) n = new Integer(args[0]);
        Long hit = IntStream.iterate(0, i -> i+1).limit(n).filter( count -> {
            double x = Math.random();
            double y = Math.random();
            return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)) <= 1;
        }).count();

        System.out.println("pi = " +(1.0*hit/n)*4 );
    }
}
