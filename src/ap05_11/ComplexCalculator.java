package ap05_11;

public class ComplexCalculator{
    void run(){
        Complex c1 = this.createComplex(5.0, -6.0);
        Complex c2 = this.createComplex(3.0,2.0);
        System.out.print("absoluate( ");
        c1.print();
        System.out.print(" ) = ");
        System.out.println(c1.absolute());
        System.out.print("conjugate( ");
        c1.print();
        System.out.print(" ) = ");
        c1.conjugate().println();

        //+
        System.out.print("( ");
        c1.print();
        System.out.print(" ) + ");

        System.out.print("( ");
        c2.print();
        System.out.print(" ) = ");
        this.add(c1,c2).println();

        //-
        System.out.print("( ");
        c1.print();
        System.out.print(" ) - ");

        System.out.print("( ");
        c2.print();
        System.out.print(" ) = ");
        this.subtract(c1,c2).println();

        //*
        System.out.print("( ");
        c1.print();
        System.out.print(" ) * ");

        System.out.print("( ");
        c2.print();
        System.out.print(" ) = ");
        this.multiply(c1,c2).println();

        // /
        System.out.print("( ");
        c1.print();
        System.out.print(" ) / ");

        System.out.print("( ");
        c2.print();
        System.out.print(" ) = ");
        this.divide(c1,c2).println();

    }

    Complex createComplex(Double realValue, Double imagValue){
        Complex c = new Complex();
        c.real = realValue;
        c.imag = imagValue;
        return c;
    }

    Complex add(Complex v1, Complex v2){
        Complex result = new Complex();
        result.real = v1.real + v2.real;
        result.imag = v1.imag + v2.imag;
        return result;
    }

    Complex subtract(Complex v1, Complex v2){
        Complex result = new Complex();
        result.real = v1.real - v2.real;
        result.imag = v1.imag - v2.imag;
        return result;
    }

    Complex multiply(Complex v1, Complex v2){
        Complex result = new Complex();
        result.real = v1.real*v2.real - v1.imag*v2.imag;
        result.imag = v1.real*v2.imag + v1.imag*v2.real;
        return result;
    }

    Complex divide(Complex v1, Complex v2){
        double a = v1.real;double b = v1.imag;
        double c = v2.real;double d = v2.imag;
        Complex result = new Complex();
        result.real = (a*c+b*d)/(c*c+d*d);
        result.imag = (a*d-b*c)/(c*c+d*d);
        return result;
    }

    public static void main(String[] args){
        new ComplexCalculator().run();
    }
}