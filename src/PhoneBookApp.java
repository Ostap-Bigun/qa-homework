public class PhoneBookApp {
    public static void main(String[] args){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "1234");
        phoneBook.add("Ivanov", "7890");
        phoneBook.add("Goncharov", "1234");

        System.out.println(phoneBook.get("Ivanov"));
    }
}
