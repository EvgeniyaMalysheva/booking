package tests;

import config.BookingConfig;
import config.ConfigReader;
import io.restassured.RestAssured;
import models.responses.BookingModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    protected BookingSteps newBooking = new BookingSteps();
    protected BookingModel newBookingData = BookingModel.builder().build();
    private static final BookingConfig config = ConfigReader.Instance.read();

    @BeforeAll
    public static void setApiParams() {
        RestAssured.baseURI = config.getBaseURI();
    }

    @AfterEach
    public void closeDriver() {
        closeWebDriver();
    }
}

