package algo;

import objects.Pizza;
import objects.Slice;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by Marius on 23.02.2017.
 */
public class PizzaCutter {

    public static int NOT_CUT = 0;
    public static int IS_CUT = 1;

    Pizza pizza = null;
    int[][] alreadyCut;

    ArrayList<Slice> slices = null;

    public PizzaCutter(Pizza pizza) {
        this.pizza = pizza;
        this.alreadyCut = new int[pizza.getR()][pizza.getC()];
        this.slices = new ArrayList<Slice>();
    }

    public void cutSmallestSlicePossible(int startRow, int startColumn) {

    }

    /**
     * Returns the new position where we can start to cut, based on the previous position
     * @param oldPoint Position where the last cut was tried
     * @return the new cut Point
     */
    public Point getNextStart(Point oldPoint) {

        if ((oldPoint.getX() == this.pizza.getC()) && (oldPoint.getY() == this.pizza.getR())){
            // we have reached the end
            return new Point(-1,-1);
        }

        Point newPoint = null;
        Point currentPos = oldPoint;
        /** go line by line */

        while(newPoint == null){
            // go right
            if ((oldPoint.getX()) + 1 < this.pizza.getC()) {
                if (isAvailable((int) currentPos.getY(), (int) currentPos.getX() + 1)) {
                    newPoint = new Point((int) currentPos.getX() + 1, (int) currentPos.getY());
                }
            } else {
                // go down
                if (isAvailable((int) currentPos.getY() + 1, 0)) {
                    newPoint = new Point(0, (int) currentPos.getY());
                }
            }

        }
        return newPoint;
    }

    private boolean isAvailable(int r, int c) {
        return alreadyCut[r][c] == NOT_CUT;
    }
}