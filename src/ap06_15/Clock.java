package ap06_15;

import java.awt.*;
import java.util.Date;

public class Clock {

    static class ClockTime{
        public final int hour;
        public final int minute;
        public final int sec;

        ClockTime(int hour,int minute,int sec){
            this.hour = hour;
            this.minute = minute;
            this.sec = sec;
        }

        public static ClockTime now(){
            Date date = new Date();
            return new ClockTime(date.getHours(),date.getMinutes(),date.getSeconds());
        }

        double secRadian(){
            double degree = this.sec * 6.0 - 90;
            return Math.toRadians(degree);
        }

        double minuteRadian(){
            double degree =  this.minute * 6.0 - 90;
            return Math.toRadians(degree);
        }
        double hourRadian(){
            double degree = (this.hour * 5 + this.minute / 12.0) * 6.0 - 90;
            return Math.toRadians(degree);
        }
    }

    void run(final int size) throws InterruptedException{
        final int center = size/2;

        EZ.initialize(size,size);
        EZCircle clockCircle = EZ.addCircle(center,center,size,size, Color.BLACK,false);
        EZLine secLine = EZ.addLine(center,center,0,0,Color.GREEN);
        EZLine minuteLine = EZ.addLine(center,center,0,0,Color.BLUE);
        EZLine hourLine = EZ.addLine(center,center,0,0,Color.RED);

        ClockTime time;
        while(true){
            time = ClockTime.now();
            final int r = size/2;
            final double secX = center + r*Math.cos(time.secRadian());
            final double secY = center + r*Math.sin(time.secRadian());
            secLine.setPoint2( (int)secX,(int)secY );
            final double minuteX = center + (r-10)*Math.cos(time.minuteRadian());
            final double minuteY = center + (r-10)*Math.sin(time.minuteRadian());
            minuteLine.setPoint2( (int)minuteX,(int)minuteY );
            final double hourX = center + (r-30)*Math.cos(time.hourRadian());
            final double houtY = center + (r-30)*Math.sin(time.hourRadian());
            hourLine.setPoint2( (int)hourX,(int)houtY );

            Thread.sleep(100);
            EZ.refreshScreen();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        new Clock().run(300);
    }
}
