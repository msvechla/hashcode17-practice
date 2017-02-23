package algo;

import objects.Pizza;
import objects.Slice;

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

    public void cutSmallestSlicePossible(int startRow, int startColumn){

    }

    public Point getNextStart(Point oldPoint){

        /** go line by line */

        // go right
        if (oldPoint.getX() + 1 < this.pizza)


    }
}