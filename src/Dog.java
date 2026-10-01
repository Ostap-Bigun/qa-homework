class Dog extends Animal {
    static int counter = 0;

    Dog(String name) {
        super(name);
        counter++;
    }

    @Override
    void run(int distance) {
        if (distance > 500) System.out.println("Ошибка! Расстояние превышает 500 м.");
        else super.run(distance);
    }

    @Override
    void swim(int distance) {
        if (distance > 10) System.out.println("Ошибка! Расстояние превышает 10 м.");
        else super.swim(distance);
    }


}
