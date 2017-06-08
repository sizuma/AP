package ap04_13;

/**
 * No.4
 */
public class FizzBuzz {
    void run(String[] args){
        Integer number = 15;
        if(args.length != 0) number = new Integer(args[0]);

        for(Integer i=1;i<=number;i++){
            if(i%3==0&&i%5==0) System.out.println("FizzBuzz");
            else if(i%3 == 0) System.out.println("Fizz");
            else if(i%5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }

    public static void main(String[] args){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.run(args);
    }
}
