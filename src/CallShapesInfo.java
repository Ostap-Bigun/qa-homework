public class CallShapesInfo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 6, "Red", "Yellow");
        Triangle triangle = new Triangle(4, 5, 6, "Yellow", "Green");
        Circle circle = new Circle(45, "Green", "Red");


        System.out.println("Rectangle stats: Perimeter - " + rectangle.perimeter() +
                ", Area - " + rectangle.area() +
                ", Fill Color - " + rectangle.fillColor +
                ", Border Color - " + rectangle.borderColor
        );
        System.out.println("Triangle stats: Perimeter - " + triangle.perimeter() +
                ", Area - " + triangle.area() +
                ", Fill Color - " + triangle.fillColor +
                ", Border Color - " + triangle.borderColor
        );
        System.out.println("Circle stats: Perimeter - " + circle.perimeter() +
                ", Area - " + circle.area() +
                ", Fill Color - " + circle.fillColor +
                ", Border Color - " + circle.borderColor);
    }
}
