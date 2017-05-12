package ap05_11;

public class Complex{
    Double real;
    Double imag;
    void print(){
        System.out.printf("%5.2f + %5.2f i", this.real, this.imag);
    }
    void println(){
        this.print();
        System.out.println();
    }

    double absolute(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(imag,2));
    }

    Complex conjugate(){
        Complex conjugate = new Complex();
        conjugate.real = real;
        conjugate.imag = -imag;
        return conjugate;
    }
}