import io.FileInputReader;
import objects.Pizza;

/**
 * Created by Marius on 23.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        FileInputReader fiExample = new FileInputReader("input/example.in");
        Pizza example = fiExample.read();

        System.out.println(example);
    }

}
