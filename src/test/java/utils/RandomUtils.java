package utils;

import java.util.Locale;
import com.github.javafaker.Faker;

public class RandomUtils {
    private static final Faker faker = new Faker(new Locale("en"));

    public static String getRandomFirstName() {

        return faker.name().firstName();
    }

    public static String getRandomLastName() {

        return faker.name().lastName();
    }

    public static int getRandomPrice() {

        return faker.number().numberBetween(100,2000);

    }

    public static String getRandomAdditionalNeeds() {

        return faker.options().option
                ("Breakfast", "Dinner", "Car", "Baby cot");
    }

    public static boolean getRandomBoolean() {

        return faker.bool().bool();
    }
}
