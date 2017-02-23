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

    public void DoWork() {
        Point p = new Point(0, 0);

        while (true) {
            Shape s = getShape();

            while (true) {
                if (p.y + s.GetHeight() < pizza.getR()
                        && p.x + s.GetWidth() < pizza.getC()
                        && isValid(p, s)) {
                    System.out.println("found new shape");
                    Slice c = new Slice(p, s);
                    slices.add(c);
                    cut(c);
                    break;
                }

                s = getShape(s);

                if (s == null) {
                    // no valid shapes anymore
                    break;
                }
            }

            p = getNextStart(p);

            if (p.y == -1 && p.x == -1) {
                // no more start options available
                break;
            }


            System.out.println(slices.size());
        }
    }

    private void cut(Slice c) {
        for (int y = c.getR1(); y < c.getR2(); y++) {
            for (int x = c.getC1(); x < c.getC2(); x++) {
                alreadyCut[y][x] = IS_CUT;
            }
        }
    }

    public boolean isValid(Point p, Shape shape) {
        int countMushroom = 0;
        int countTomato = 0;

        for (int i = 0; i < shape.GetHeight(); i++) {
            for (int j = 0; j < shape.GetWidth(); j++) {
                if (!isAvailable(p.y + i, p.x + j)) {
                    return false;
                }

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

        Shape newShape = null;

        // check if shape crosses bounds
        if (lastShape.GetWidth() >= pizza.getC()) {
            // reduce with to one
            lastShape.SetWidth(1);
            // expand height
            lastShape.SetHeight(lastShape.GetWidth() + 1);
            newShape = lastShape;
        } else {
            // expand width
            lastShape.SetWidth(lastShape.GetWidth() + 1);
            newShape = lastShape;
        }

        System.out.println("New Shape: " + newShape.GetWidth() + "x" + newShape.GetHeight());

        return newShape;
    }

    /**
     * Returns the new position where we can start to cut, based on the previous position
     *
     * @param oldPoint Position where the last cut was tried
     * @return the new cut Point
     */
    public Point getNextStart(Point oldPoint) {

        if ((oldPoint.getX() == this.pizza.getC() - 1) && (oldPoint.getY() == this.pizza.getR() - 1)) {
            // we have reached the end
            return new Point(-1, -1);
        }

        Point newPoint = null;
        Point currentPos = oldPoint;
        /** go line by line */

        while (newPoint == null) {
            // go right
            if ((currentPos.getX()) + 1 < this.pizza.getC()) {
                if (isAvailable((int) currentPos.getY(), (int) currentPos.getX() + 1)) {
                    newPoint = new Point((int) currentPos.getX() + 1, (int) currentPos.getY());
                } else {
                    currentPos = new Point((int) currentPos.getX() + 1, (int) currentPos.getY());
                }
            } else {
                // go down
                if (isAvailable((int) currentPos.getY() + 1, 0)) {
                    newPoint = new Point(0, (int) currentPos.getY() + 1);
                }else{
                    currentPos = new Point(0, (int) currentPos.getY() + 1);
                }
            }

        }

        System.out.println("New StartPoint: " + newPoint.y + "," + newPoint.x);

        return newPoint;
    }

    private boolean isAvailable(int r, int c) {
        return alreadyCut[r][c] == NOT_CUT;
    }
}