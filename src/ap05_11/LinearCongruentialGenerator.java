package ap05_11;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class LinearCongruentialGenerator {

    Stream<Double> generateStream(double a,double b,double m,double x_0){
        return DoubleStream.iterate(x_0, xn -> (a*xn+b)%m ).map(xn -> xn/m).boxed();
    }
    void run(String[] args){
        int n = 10;
        if(args.length > 0) n = new Integer(args[0]);
        String str = generateStream(512,1,65536,19)
                .skip(1).limit(n)
                .map(random -> random.toString())
                .collect(Collectors.joining(","));
        System.out.println("["+str+"]");
    }

    public static void main(String[] args){
        new LinearCongruentialGenerator().run(args);
    }
}
