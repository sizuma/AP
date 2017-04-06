package ap04_06;

/**
 * No.3
 */
public class LeapYear{
    public static void main(String[] args){
        Integer year = 200;
        Boolean leapYear = false;
        // ここに判定処理を書いていく．
        if(year % 4 == 0) {
            if(year % 100 == 0 && year % 400 == 0) leapYear = true;
            else if(year % 100 != 0) leapYear = true;
        }else leapYear = false;

        if(leapYear){ // leapYearがtrueの場合．
            System.out.printf("%d年はうるう年です．%n", year);
        }
        else{
            System.out.printf("%d年はうるう年ではありません．%n", year);
        }
    }
}
