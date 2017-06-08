package ap05_18;

import java.awt.*;

public class ThrowingExercise {

    final int width = 400;
    final int height = 400;

    void run(){
        EZ.initialize(width,height);
        EZCircle xAxis = EZ.addCircle(100, 100, 5, 5, Color.BLUE, true);
        EZCircle red = EZ.addCircle(100, 0, 5, 5, Color.RED, true);
        EZCircle green = EZ.addCircle(200,0,5,5,Color.GREEN,true);

        this.roundTrip(xAxis,red,green);
    }

    void roundTrip(EZCircle xAxis,EZCircle red,EZCircle green){
        Integer deltaX = 10;
        final double g = 9.8;
        BouncyBall redBall = new BouncyBall(red,0,false);
        BouncyBall greenBall = new BouncyBall(green,10,false);
        while(true){
            Integer newX = xAxis.getXCenter() + deltaX;
            xAxis.translateTo(newX, xAxis.getYCenter());
            if(newX >= 400 || newX <= 0){
                deltaX = deltaX * -1;
            }

            redBall.circle.translateTo(redBall.circle.getXCenter(),redBall.getY());
            redBall.next();
            greenBall.circle.translateTo(greenBall.circle.getXCenter(),greenBall.getY());
            greenBall.next();
            EZ.refreshScreen();
            try{ Thread.sleep(100); }
            catch (InterruptedException e){}
        }
    }


    public static void main(String[] args){
        new ThrowingExercise().run();
    }
}
