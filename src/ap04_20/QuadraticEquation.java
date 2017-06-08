package ap04_20;

/**
 * No.3
 */
public class QuadraticEquation {
    double discriminant(double a,double b,double c){
        return b*b-4*a*c;
    }

    void run(String[] args){
        double a = new Double(args[0]);
        double b = new Double(args[1]);
        double c = new Double(args[2]);
        double d = discriminant(a,b,c);
        System.out.print("answer = ");
        if(d > 0){
            double resultA = (-b+Math.sqrt(d))/2*a;
            double resultB = (-b-Math.sqrt(d))/2*a;
            System.out.printf("%f, %f",resultA,resultB);
        }else if(d == 0){
            double result = (-b)/2*a;
            System.out.printf("%f",result);
        }else{
            double resultR = -b/2*a;
            double resultI = Math.sqrt(-d)/2*a;
            System.out.printf("%f + %f i,%f - %f i",resultR,resultI,resultR,resultI);
        }
    }

    public static void main(String[] args){
        QuadraticEquation qe = new QuadraticEquation();
        qe.run(args);
    }

}
