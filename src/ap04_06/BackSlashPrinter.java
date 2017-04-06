package ap04_06;

/**
 * No.6
 */
public class BackSlashPrinter {
    public static void main(String[] args){
        Integer width = 10;
        char cs[] = new char[width];
        for(Integer i=0;i<width;i++) cs[i] = '.';
        for(Integer i=0;i<width;i++){
            cs[i] = 'X';
            System.out.println(new String(cs));
            cs[i] = '.';
        }

    }
}
