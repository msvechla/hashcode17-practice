package io;

import objects.Pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Marius on 23.02.2017.
 */
public class FileInputReader {

    private String input_file = "C:/Users/Marius/Downloads/example.in";
    private File file;

    public FileInputReader(String input_file) {
        super();
        this.input_file = input_file;
        this.file = new File(this.input_file);
    }

    public Pizza read() {

        int r = 0, c = 0, l = 0, h = 0;
        int[][] pizza = null;

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            // read static values
            String line = br.readLine();

            String staticValues[] = line.split(" ");
            r = Integer.parseInt(staticValues[0]);
            c = Integer.parseInt(staticValues[1]);
            l = Integer.parseInt(staticValues[2]);
            h = Integer.parseInt(staticValues[3]);

            pizza = new int[r][c];

            for (int i = 0; i < r; i++) {
                line = br.readLine();
                line = line.replace("T", String.valueOf(Pizza.TOMATO));
                line = line.replace("M", String.valueOf(Pizza.MUSHROOM));

                for (int j = 0; j < line.length(); j++) {
                    pizza[i][j] = Character.getNumericValue(((line.charAt(j))));
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new Pizza(r, c, l, h, pizza);
    }
}

