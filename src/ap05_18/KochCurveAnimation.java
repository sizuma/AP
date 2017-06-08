package ap05_18;

public class KochCurveAnimation extends KochCurve{
    @Override
    void run(String[] args) {
        EZ.initialize(400,400);
        for(int i=0;i<=5;i++){
            EZ.addText(10,10,"n="+i);
            drawKoch(0,100,400,100,i,0);
            try { Thread.sleep(3000); }
            catch(InterruptedException e){
                System.out.println(e);
            }
            EZ.removeAllEZElements();
            EZ.refreshScreen();

        }
    }

    public static void main(String[] args){
        new KochCurveAnimation().run(args);
    }
}
