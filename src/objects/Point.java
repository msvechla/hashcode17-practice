package objects;

/**
 * Created by tobia on 2/23/2017.
 */
public class Point {
    public int c;
    public int r;

    public Point(int r, int c) {
        this.c = c;
        this.r = r;
    }

    public String ToString() {
        return "r:" + r + " c:" + c;
    }
}
