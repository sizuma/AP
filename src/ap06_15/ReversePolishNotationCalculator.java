package ap06_15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teppei Shiroyama under MIT License.
 */
public class ReversePolishNotationCalculator {

    List<String> stack = new ArrayList<>();

    boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("-");
    }

    void push(String elem){
        if(isOperator(elem)) pushOperator(elem);
        else stack.add(elem);
    }

    void pushOperator(String operator){
        final int size = stack.size();
        int last_2 = new Integer( stack.get(size-2) );
        int last_1 = new Integer( stack.get(size-1) );
        int result = 0;

        switch (operator){
            case "+" : result = last_2 + last_1; break;
            case "-" : result = last_2 - last_1; break;
            case "*" : result = last_2 * last_1; break;
            case "/" : result = last_2 / last_1; break;
        }
        stack.remove(stack.size()-1);
        stack.remove(stack.size()-1);
        push(String.valueOf(result));

    }
    void run (String form){
        for(String elem : form.split(" ")){
            push(elem);
        }
        System.out.println(stack.get(0) + " ( " + form+" )");
    }

    public static void main(String[] args){
        for(String arg : args) new ReversePolishNotationCalculator().run(arg);
    }
}
