public class Bowl {
    int foodAmount = 0;

    void addFood(int food) {
        foodAmount = foodAmount + food;
        System.out.println("В миске " + foodAmount + " еды.");
    }
}
