package ap04_20;

import java.util.stream.DoubleStream;

/**
 * No.5
 */
public class TrapezoidalRulePi {
    public static void main(String[] args){
        double _step = 0.001;
        if(args.length > 0) _step = new Double(args[0]);
        final double step = _step;
        final double pi = DoubleStream.iterate(step,d -> d + step).limit((long)(1.0 / step)-1).map(xn -> {
            double xn_1 = xn - step;
            double w = xn - xn_1;
            double hn = Math.sqrt(1-Math.pow(xn,2));
            double hn_1 = Math.sqrt(1-Math.pow(xn_1,2));
            double h = hn+hn_1;
            return w*h/2;
        }).sum()*4;
        System.out.printf("%6.5f",pi);
        System.out.println();
    }
}
