package objects;


/**
 * Created by Marius on 23.02.2017.
 */
public class Slice {

    int r1, r2, c1, c2;

    public Slice(Point p, Shape s) {
        r1 = p.r;
        r2 = p.r + s.GetHeight();

        c1 = p.c;
        c2 = p.c + s.GetWidth();
    }

    public int getR1() {
        return r1;
    }

    public int getR2() {
        return r2;
    }

    public int getC1() {
        return c1;
    }

    public int getC2() {
        return c2;
    }

    public String ToString() {
        return "r[" + r1 + "->" + r2 + "]c[" + c1 + "->" + c2 + "]";
    }
}
