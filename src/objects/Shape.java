package objects;

/**
 * Created by tobia on 2/23/2017.
 */
public class Shape {
    int width = -1;
    int height = -1;

    public Shape(int w, int h) {
        width = w;
        height = h;
    }

    public int GetHeight(){
        return height;
    }
    public int GetWidth(){
        return  width;
    }

    public void SetWidth(int w){
        width = w;
    }

    public void SetHeight(int h){
        height = h;
    }
}
