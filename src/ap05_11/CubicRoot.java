package ap05_11;

public class CubicRoot {

    double f(double x,double n){
        return Math.pow(x,3) - n;
    }
    Double calculate(Double n){
        Double threshold = 0.00001;
        Double x = 10.0;
        Double y = f(x,n);
        while(y > threshold){
            double slant = 3*Math.pow(x,2);
            double b = y - slant*x;
            x = -b/slant;
            y = f(x,n);
        }
        return x;
    }
    void run(String[] args){
        for(String arg : args){
            System.out.printf("cubic_root(%s) = %8.7f",arg,calculate(new Double(arg)));
            System.out.println();
        }

    }
    public static void main(String[] args){
        new CubicRoot().run(args);
    }
}
