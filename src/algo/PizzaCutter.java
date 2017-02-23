package algo;

import objects.Slice;
import objects.Shape;

import java.util.ArrayList;

/**
 * Created by Marius on 23.02.2017.
 */
public class PizzaCutter {

    int[][] pizza = null;
    ArrayList<Slice> slices = null;

    public PizzaCutter(int[][] pizza) {
        this.pizza = pizza;
        this.slices = new ArrayList<Slice>();
    }

    public void cutSmallestSlicePossible(int startRow, int startColumn) {

    }

    public Shape GetShape(int min) {
        int w = (int) Math.round(Math.sqrt(min));
        int h = (int) Math.round(Math.sqrt(min));

        if (w * h < min) {
            w++;
        }

        if (w * h < min) {
            h++;
        }

        return GetShape(min, new Shape(w, h));
    }

}