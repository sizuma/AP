package ap05_11;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BigFibonacci {

    void run(String[] args){
        if(args.length > 0){
            for(String arg : args){
                System.out.println("fibonacci("+arg+") = "+getFibonacci(new BigInteger(arg)));
            }
        }else{
            System.out.println("fibonacci("+10+") = "+getFibonacci(new BigInteger("10")));
        }
    }

    BigInteger getFibonacci(BigInteger index){
        Map<BigInteger,BigInteger> results = new HashMap<>();
        results.put(new BigInteger("1"),new BigInteger("1"));
        results.put(new BigInteger("2"),new BigInteger("1"));

        for(BigInteger i = new BigInteger("3") ; i.compareTo(index) <= 0;i = i.add(new BigInteger("1"))){
            BigInteger i_1 = results.get(i.subtract(new BigInteger("1")));
            BigInteger i_2 = results.get(i.subtract(new BigInteger("2")));
            BigInteger added = i_1.add(i_2);

            results.put(i,added);
        }
        return results.get(index);
    }
    public static void main(String[] args){
        new BigFibonacci().run(args);
    }
}
