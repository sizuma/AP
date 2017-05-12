package ap04_27;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StatsValues {

    Stream<Integer> generateRandomStream(){
        Random random = new Random();
        return IntStream.iterate(0,i -> i+1)
                .mapToObj(count -> random.nextInt(1000));
    }

    void printSumMaxMinAvg(List<Integer> list){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int elem:list){
            sum += elem;
            if(elem > max) max = elem;
            if(elem < min) min = elem;
        }
        double avg = 1.0*sum/1000;
        System.out.printf("合計：%d,最大：%d,最小：%d,平均値：%f",sum,max,min,avg);
        System.out.println();
    }

    void printList(List<Integer> list){
        int count = 0;
        for(int elem:list){
            System.out.printf("%3d ",elem);
            count ++;
            if(count % 10 == 0) System.out.println();
        }
    }

    void run(){
        List<Integer> list = generateRandomStream().limit(1000).collect(Collectors.toList());
        printSumMaxMinAvg(list);
        printList(list);
    }


    public static void main(String[] args){
        new StatsValues().run();
    }
}
