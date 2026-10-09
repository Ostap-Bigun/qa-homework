import java.util.*;

public class PhoneBook {
    Map<String, List<String>> contacts;

    PhoneBook() {
        contacts = new HashMap<>();
    }

    void add(String lastName, String number) {
        if (contacts.containsKey(lastName)) {
            List<String> numbers = contacts.get(lastName);
            numbers.add(number);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            contacts.put(lastName, numbers);

        }
    }

    List<String> get(String lastName){
        return contacts.get(lastName);
    }

}

