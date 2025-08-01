package config;

import io.restassured.RestAssured;

public class ProjectConfiguration {
    private final BookingConfig bookingConfig;

    public ProjectConfiguration(BookingConfig bookingConfig) {
        this.bookingConfig = bookingConfig;
    }

    public void apiConfig() {
        System.out.println("Base URI: " + bookingConfig.getBaseURI());
        RestAssured.baseURI = bookingConfig.getBaseURI();
    }
}
