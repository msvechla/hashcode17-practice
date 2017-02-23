package objects;

import java.awt.*;

/**
 * Created by Marius on 23.02.2017.
 */
public class Slice {

    int r1, r2, c1, c2;

    public Slice(Point p, Shape s) {
        r1 = p.y;
        r2 = p.y + s.GetHeight();

        c1 = p.x;
        c2 = p.x + s.GetWidth();
    }

    public int getR1(){
        return r1;
    }
    public int getR2(){
        return r2;
    }
    public int getC1(){
        return c1;
    }
    public int getC2(){
        return c2;
    }
}
