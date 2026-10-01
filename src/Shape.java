public interface Shape {
    double perimeter();

    double area();

    default double sumSides(double... sides) {
        double sum = 0;
        for (int i = 0; i < sides.length; i++) {
            sum = sum + sides[i];
        }
        return sum;
    }
}
