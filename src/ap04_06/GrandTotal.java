package ap04_06;

/**
 * No.4
 */
public class GrandTotal {
    public static void main(String[] args){
        Integer result = 0;
        Integer i;
        for(i = 1;i <= 10;i++) result += i;
        System.out.println("1から10までの総和は"+result+"です");
    }
}
