package ap04_27;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciList_644628 {
    void run(String[] args){
        int maxIndex = 10;
        if(args.length > 0) maxIndex = new Integer(args[0]);
        printList(getFibonacciList(maxIndex));
    }

    void printList(List<Integer> list){
        System.out.println("["+list.stream().map(String::valueOf).collect(Collectors.joining(","))+"]");
    }
    public static void main(String[] args){
        new FibonacciList_644628().run(args);
    }

    List<Integer> getFibonacciList(int maxIndex){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        for(int i=2;i<maxIndex;i++){
            list.add(i,list.get(i-1)+list.get(i-2));
        }
        return list;
    }
}
