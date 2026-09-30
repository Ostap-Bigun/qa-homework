import java.time.LocalDate;

public class Product {
    String name;
    LocalDate manufacturedDate;
    String manufacturer;
    String country;
    int price;
    boolean booked;

    public Product(String name,
                   LocalDate manufacturedDate,
                   String manufacturer,
                   String country,
                   int price,
                   boolean booked) {
        this.name = name;
        this.manufacturedDate = manufacturedDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.booked = booked;
    }

    public void ProductInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + manufacturedDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Бронь: " + booked);
    }

    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product(
                "Samsung Galaxy S21",
                LocalDate.of(2021, 01, 01),
                "Samsung Corp.",
                "Korea",
                100000,
                true
        );
        productsArray[1] = new Product(
                "Samsung Galaxy S22",
                LocalDate.of(2022, 01, 01),
                "Samsung Corp.",
                "Korea",
                110000,
                true
        );
        productsArray[2] = new Product(
                "Samsung Galaxy S23",
                LocalDate.of(2023, 01, 01),
                "Samsung Corp.",
                "Korea",
                120000,
                true
        );
        productsArray[3] = new Product(
                "Samsung Galaxy S24",
                LocalDate.of(2024, 01, 01),
                "Samsung Corp.",
                "Korea",
                130000,
                false);
        productsArray[4] = new Product(
                "Samsung Galaxy S25",
                LocalDate.of(2025, 01, 01),
                "Samsung Corp.",
                "Korea",
                140000,
                false);
    }
}