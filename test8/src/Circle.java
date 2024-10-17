public class Circle implements Figura {

    public static double PI = 3.1416;

    private double radio;

    public Circle(double radio) {  //Constructor
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calculateArea() {
        return PI * radio * radio;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radio;
    }
}
