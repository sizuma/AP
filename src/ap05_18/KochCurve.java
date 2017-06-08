package ap05_18;

import java.awt.*;

public class KochCurve {
    void run(String[] args){
        int n = 3;
        if(args.length > 0) n = new Integer(args[0]);
        EZ.initialize(400,400);
        EZ.addText(10,10,"n="+n);
        drawKoch(0,100,400,100,n,0);
    }

    void drawKoch(int x1,int y1,int x5,int y5,int dimension,double angel){
        if(dimension == 0){
            EZ.addLine(x1,y1,x5,y5, Color.RED);
        }else {
            double l = Math.sqrt(Math.pow(x5 - x1, 2) + Math.pow(y5 - y1, 2)) / 3;
            double delta = Math.PI / 3.0;

            double x2 = x1 + l * Math.cos(angel);
            double y2 = y1 + l * Math.sin(angel);
            double x3 = x2 + l * Math.cos(angel + delta);
            double y3 = y2 + l * Math.sin(angel + delta);
            double x4 = x3 + l * Math.cos(angel - delta);
            double y4 = y3 + l * Math.sin(angel - delta);
            EZ.addLine( (int)x1, (int)y1, (int)x2, (int)y2,Color.RED);
            this.drawKoch((int) x2, (int) y2, (int) x3, (int) y3, dimension - 1, angel + delta);
            this.drawKoch((int) x3, (int) y3, (int) x4, (int) y4, dimension - 1, angel - delta);

            EZ.addLine( (int)x4, (int)y4,x5,y5,Color.RED);
        }
    }

    public static void main(String[] args){
        new KochCurve().run(args);
    }
}
