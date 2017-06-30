package ap06_15;

public class ArgsReverser {
    void run(String[] args){
        for (String arg : args){
            final int length = arg.length();
            System.out.print(arg+", ");
            for(int index = length-1;index >= 0;index--) System.out.print(arg.charAt(index));
            System.out.println();
        }
    }

    public static void main(String[] args){
        new ArgsReverser().run(args);
    }
}
