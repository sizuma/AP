package ap05_18;

public class BouncyBall {
    final EZCircle circle;
    final double g = 9.8;
    double ax;
    double v0;
    double y0;
    double t;
    boolean isFalling;

    public BouncyBall(EZCircle circle,double ax,boolean isFalling){
        this.circle = circle;
        this.isFalling = isFalling;
        setParameter(this.isFalling);
        this.ax = ax;
    }

    double getV(){
        return v0 - g * t;
    }

    double getY(){
        if(this.isFalling) {
            return y0 + (v0*t - 1.0/2*(g*t*t));
        }
        else return (v0*t - 1.0/2*g*t*t);
    }

    void next(){
        this.t += 0.1;
        double x = circle.getXCenter() + ax;
        if(x > 400 || x < 0){
            ax *= -1;
        }
        circle.translateTo(x,circle.getYCenter());
        if(this.isFalling && getY() < 5){
            this.isFalling = false;
            setParameter(this.isFalling);
        }else if(!this.isFalling && getV() < 0){
            this.isFalling = true;
            setParameter(this.isFalling);
        }
    }
    void setParameter(boolean isFalling){
        this.t = 0;
        if(isFalling){
            v0 = 0.0;
            y0 = 368.62;
        }else{
            v0 = 85;
            y0 = 0;
        }
    }
}
