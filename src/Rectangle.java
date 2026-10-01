public class Rectangle implements Shape {
    int a;
    int b;
    String fillColor;
    String borderColor;

    Rectangle(int a, int b, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        double perimeter = sumSides(a, a, b, b);
        return perimeter;
    }

    @Override
    public double area() {
        double area = a * b;
        return area;
    }
}
