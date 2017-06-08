package ap04_06;

/**
 * No.5
 */
public class Multiplication {
    public static void main(String[] args){
        System.out.print("  ");

        for(Integer i=1;i<=9;i++) System.out.printf("%2d ",i);
        System.out.println();
        for(Integer i=1;i<=9;i++){
            System.out.printf("%d ",i);
            for(Integer j=1;j<=9;j++) System.out.printf("%2d ",i*j);
            System.out.println();
        }
    }
}
