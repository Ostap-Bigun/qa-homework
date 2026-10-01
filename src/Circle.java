public class Circle implements Shape {
    int radius;
    String fillColor;
    String borderColor;

    Circle(int radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        double perimeter = 2.0 * Math.PI * radius;
        return perimeter;
    }

    @Override
    public double area() {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
}
