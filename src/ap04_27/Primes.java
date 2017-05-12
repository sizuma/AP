package ap04_27;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Primes {

    boolean isPrime(int number){
        int sqrt = (int)Math.sqrt(number);
        for(int i=2;i<=sqrt;i++){
            if(number % i == 0)return false;
        }
        return true;
    }

    List<Integer> generatePrimes(Integer max){
        return IntStream.iterate(2,i -> i+1)
                .limit(max)
                .filter(this::isPrime)
                .boxed().collect(Collectors.toList());
    }

    public static void main(String[] args){
        int n = 200;
        if(args.length > 0) n = new Integer(args[0]);
        List<Integer> primes = new Primes().generatePrimes(n);

        for(int i=0;i<primes.size();i++){
            System.out.printf("%3d ",primes.get(i));
            if( (i+1)%10 == 0 ) System.out.println();
        }
    }
}
