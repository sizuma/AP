package ap04_27;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Factorizer {

    boolean isPrime(int number){
        int sqrt = (int)Math.sqrt(number);
        for(int i=2;i<=sqrt;i++){
            if(number % i == 0)return false;
        }
        return true;
    }

    List<Integer> factorizer(int number){
        if(isPrime(number)){
            List<Integer> result = new ArrayList<>();
            result.add(number);
            return result;
        }
        int prime = new Primes().generatePrimes(number)
                .stream()
                .filter(n -> number % n == 0)
                .mapToInt(Integer::intValue)
                .max().getAsInt();

        List<Integer> result = new ArrayList<>(factorizer(number/prime));
        result.add(prime);
        return result;
    }

    void run(String[] args){
        for(String arg : args) {
            String factorized = factorizer(new Integer(arg))
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" x "));
            System.out.println(arg + ":" +factorized);
        }
    }

    public static void main(String[] args){
        Factorizer factorizer = new Factorizer();
        factorizer.run(args);
    }
}
