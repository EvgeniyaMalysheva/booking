package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.BookingConfig;
import config.ConfigReader;
import config.ProjectConfiguration;
import helpers.ApiHelper;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import models.responses.BookingModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    protected BookingSteps newBooking = new BookingSteps();
    protected BookingModel newBookingData = BookingModel.builder().build();
    protected ApiHelper apiHelper = new ApiHelper();
    private static final BookingConfig config = ConfigReader.Instance.read();

    @BeforeAll
    public static void setApiParams() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(config);
        projectConfiguration.apiConfig();
    }

    @BeforeEach
    public void addAllureSelenideListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void сloseDriver() {
        closeWebDriver();
    }
}

