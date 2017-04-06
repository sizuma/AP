package ap04_06;

/**
 * No.1
 */
public class BigAndSmall {
    public static void main(String[] args){
        Double value = Math.random();

        System.out.printf("value: %f:",value);

        if(value < 0.5) System.out.println("Small");
        else System.out.println("Big");
    }
}
