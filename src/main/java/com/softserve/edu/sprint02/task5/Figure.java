package sprint02.task5;

import java.util.List;

public class Figure {
    private double width;
    double getPerimeter() {
        return width;
    }
}

class Rectang extends Figure{
    private double width;
    private double height;

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getPerimeter() {
        return (getHeight()+getWidth())*2;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
class Square extends Figure{
    private double width;

    public Square(double width) {
        this.width = width;
    }
    public double getPerimeter() {
        return 4*getWidth();
    }

    public double getWidth() {
        return width;
    }
}
class MyUtils {
    public double sumPerimeter(List<Figure> figures) {
        double result = 0;
        for (Figure f:figures) {
            if (f instanceof Square) {
                result += f.getPerimeter();
            }
            if (f instanceof Rectang) {
                result += f.getPerimeter();
            }
        }
        return result;
    }
}

