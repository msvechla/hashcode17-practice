package objects;

import java.util.Arrays;

/**
 * Created by Marius on 23.02.2017.
 */
public class Pizza {

    public static int TOMATO = 0;
    public static int MUSHROOM = 1;

    private int R; //number of rows
    private int C; //number of columns
    private int L; //min number of each ingredient cells in a slice
    private int H; //max number of cells in slice

    private int pizza[][];

    public Pizza(int r, int c, int l, int h, int pizza[][]) {
        super();
        R = r;
        C = c;
        L = l;
        H = h;
        this.pizza = pizza;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getL() {
        return L;
    }

    public void setL(int l) {
        L = l;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    public int[][] getPizza() {
        return pizza;
    }

    public void setPizza(int[][] pizza) {
        this.pizza = pizza;
    }

    public String toString(){
        return "Pizza: " + Arrays.deepToString(this.pizza);
    }

}
