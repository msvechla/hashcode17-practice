package io;

import algo.PizzaCutter;
import objects.Slice;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by MSVECHL on 23.02.2017.
 */
public class FileOutputWriter {

    private String output_file = "output/practice.out";
    private File file;
    private PizzaCutter pizzaCutter;

    public FileOutputWriter(String output_file, PizzaCutter pizzaCutter) {
        super();
        this.output_file = output_file;
        this.file = new File(this.output_file);
        this.pizzaCutter = pizzaCutter;
    }

    public void writeFile() {

        try {
            FileOutputStream fos = new FileOutputStream(this.output_file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            bw.write(String.valueOf(pizzaCutter.getSlices().size()));
            for (Slice s : pizzaCutter.getSlices()) {
                bw.newLine();
                bw.write(s.getR1() + " " + s.getR2() + " " + s.getC1() + " " + s.getC2());
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
