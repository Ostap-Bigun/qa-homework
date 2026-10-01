public class Animal {
    String name;
    static int counter = 0;

    Animal(String name) {
        this.name = name;
        counter++;
    }

    void run(int distance) {
        System.out.println(name + " пробежал(а) " + distance + "м");
    }

    void swim(int distance) {
        System.out.println(name + " проплыл(а) " + distance + "м");
    }
}
