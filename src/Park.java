import java.time.LocalTime;

public class Park {
    class Attraction {
        String attractionName;
        LocalTime openingTime;
        LocalTime closingTime;
        int price;

        public Attraction(String attractionName,
                          LocalTime openingTime,
                          LocalTime closingTime,
                          int price) {
            this.attractionName = attractionName;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;

        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        Attraction[] attractionsArray = new Attraction[10];
        attractionsArray[5] = park.new Attraction(
                "Roller Coaster",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0),
                50
        );
    }
}
