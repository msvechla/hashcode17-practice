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

    Pizza pizza = null;
    ArrayList<Slice> slices = null;

    public PizzaCutter(Pizza pizza) {
        this.pizza = pizza;
        this.slices = new ArrayList<Slice>();
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

    public Shape getShape(Shape lastSlice) {
        if (lastSlice.GetSize() >= this.pizza.getH()) {
            return null;
        }

        if (lastSlice.GetWidth() >= pizza.getC()) {
            lastSlice.SetWidth(1);
            lastSlice.SetHeight(lastSlice.GetWidth() + 1);
            return lastSlice;
        }

        lastSlice.SetWidth(lastSlice.GetWidth() + 1);
        return lastSlice;
    }


    public Point getNextStart(Point oldPoint) {

        /** go line by line */

        // go right
        //if (oldPoint.getX() + 1 < this.pizza)


    }
}