class Cat extends Animal {
    static int counter = 0;
    boolean isFull = false;

    Cat(String name) {
        super(name);
        counter++;
    }

    @Override
    void run(int distance) {
        if (distance > 200) System.out.println("Ошибка! Расстояние превышает 200 м.");
        else super.run(distance);
    }

    @Override
    void swim(int distance) {
        System.out.println("Ошибка! Животное не умеет плавать.");
    }

    void eat(int foodEaten, Bowl bowl) {
        if (foodEaten <= bowl.foodAmount) {
            isFull = true;
            bowl.foodAmount = bowl.foodAmount - foodEaten;
        }

    }


}
