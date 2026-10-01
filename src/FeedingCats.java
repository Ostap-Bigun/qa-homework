public class FeedingCats {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Cat1");
        cats[1] = new Cat("Cat2");
        cats[2] = new Cat("Cat3");

        Bowl bowl = new Bowl();
        bowl.addFood(50);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(20, bowl);
            System.out.println("Кот/кошка " + cats[i].name + " сыт(а) : " + cats[i].isFull);

        }


    }
}
