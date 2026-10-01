public class Triangle implements Shape {
    int a;
    int b;
    int c;
    String fillColor;
    String borderColor;

    Triangle(int a, int b, int c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        double perimeter;
        perimeter = sumSides(a, b, c);
        return perimeter;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2.0;
        double area;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }
}
