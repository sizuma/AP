package ap04_20;

import java.util.Arrays;

/**
 * No.1
 */
public class ArgsSorter{
    void run(String[] args){
        System.out.print("before:");
        printArray(args);
        System.out.println();
        Arrays.sort(args);
        System.out.print("after:");
        printArray(args);
        System.out.println();
    }

    void printArray(String[] array){
        Arrays.stream(array).map(elem -> " "+elem+",").forEach(System.out::print);
    }

    public static void main(String[] args){
        new ArgsSorter().run(args);
    }


}