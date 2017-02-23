package algo;

import objects.Pizza;
import objects.Slice;
import objects.Shape;

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

    public boolean isValid(Point p, Shape shape) {
        int countMushroom = 0;
        int countTomato = 0;

        for (int i = 0; i < shape.GetHeight(); i++) {
            for (int j = 0; j < shape.GetWidth(); j++) {
                if (pizza.getPizza()[p.y + i][p.x + j] == Pizza.TOMATO) {
                    countTomato++;
                    continue;
                }

                if (pizza.getPizza()[p.y + i][p.x + j] == Pizza.MUSHROOM) {
                    countMushroom++;
                    continue;
                }
            }
        }

        if (Math.min(countMushroom, countTomato) >= pizza.getL()) {
            return true;
        } else {
            return false;
        }
    }

    public void cutSmallestSlicePossible(int startRow, int startColumn) {

    }

    /**
     * Returns the new position where we can start to cut, based on the previous position
     * @param oldPoint Position where the last cut was tried
     * @return the new cut Point
     */
    public Point getNextStart(Point oldPoint) {
    public Shape getShape() {
        int min = this.pizza.getL();

        int w = (int) Math.round(Math.sqrt(min));
        int h = (int) Math.round(Math.sqrt(min));

        if (w * h < min) {
            w++;
        }

        if (w * h < min) {
            h++;
        }

        return getShape(new Shape(w, h));
    }

    public Shape getShape(Shape lastShape) {
        // check if shape reached max size
        if (lastShape.GetSize() >= this.pizza.getH()) {
            return null;
        }

        // check if shape crosses bounds
        if (lastShape.GetWidth() >= pizza.getC()) {
            // reduce with to one
            lastShape.SetWidth(1);
            // expand height
            lastShape.SetHeight(lastShape.GetWidth() + 1);
            return lastShape;
        }

        // expand width
        lastShape.SetWidth(lastShape.GetWidth() + 1);
        return lastShape;
    }

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