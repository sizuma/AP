package ap04_20;


/**
 * No.2
 */
public class StudentIdValidator {
    public static void main(String[] args){
        char digits[] = args[0].toCharArray();
        System.out.print(new String(digits)+":");
        if(digits.length != 6) System.out.println("invalid");
        else{
            Integer sum = 0;
            for(char digit : digits) sum += '0' - digit;
            if(sum % 10 == 0) System.out.println("valid");
            else System.out.println("invalid");
        }
    }
}
