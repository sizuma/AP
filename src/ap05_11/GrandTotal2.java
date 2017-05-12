package ap05_11;

public class GrandTotal2 {

    void run(String[] args){
        int max = 10;
	if(args.length > 0) max = new Integer(args[0]);
        System.out.print("1から"+max+"までの総和は");
        System.out.print(sum(1,0,max));
        System.out.println("です");
    }

    int sum(int current,int sum,int max){
        if(current > max) return sum;
        else return sum(current+1,sum+current,max);
    }
    public static void main(String[] args){
        new GrandTotal2().run(args);
    }
}
