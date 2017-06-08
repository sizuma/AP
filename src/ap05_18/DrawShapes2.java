package ap05_18;

import java.awt.*;

public class DrawShapes2 {
    void run(){
        EZ.initialize(400,400);
        EZ.addRectangle(200,200,200,200, Color.BLUE,true);
        EZ.addCircle(200,200,200,200,Color.WHITE,true);
        EZ.addPolygon(new int[]{50,200,350,200},new int[]{200,350,200,50},Color.RED,false);
    }

    public static void main(String[] args){
        new DrawShapes2().run();
    }
}
