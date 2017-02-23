import algo.PizzaCutter;
import io.FileInputReader;
import io.FileOutputWriter;
import objects.Pizza;

/**
 * Created by Marius on 23.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        FileInputReader fiExample = new FileInputReader("input/example.in");
        Pizza example = fiExample.read();

        PizzaCutter cutter = new PizzaCutter(example);
        cutter.DoWork();

        FileOutputWriter foExample = new FileOutputWriter("output/example.out", cutter);
        foExample.writeFile();
        System.out.println(example);
    }

}
