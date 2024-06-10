package commons;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerConfig {
    static Faker faker = new Faker(new Locale("en-US"));
    public static FakerConfig getFaker() {
        return new FakerConfig();
    }
    public static String getFirstName() {
        return faker.name().firstName();
    }
}
