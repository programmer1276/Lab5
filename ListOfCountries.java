package Commands;

import Classes.Country;
import Console.MyConsole;

import java.util.HashMap;
import java.util.SplittableRandom;

public class ListOfCountries {
    private static Integer count = 0;
    private static HashMap<String, String> countries = new HashMap<>();
    public static void execute() {
        for (var country : Country.values()) {
            Integer number = count++;
            MyConsole.printf("%s: %s\n", number, country);
            countries.put(number.toString(), country.toString());
        }
    }

    public static HashMap<String, String> getCountries() {
        return countries;
    }
}
