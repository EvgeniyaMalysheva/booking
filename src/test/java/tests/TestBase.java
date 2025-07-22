package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
//import config.ConfigReader;
//import config.ProjectConfiguration;
//import config.WebConfig;
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

       @BeforeAll
        public static void setBrowserParams() {
           RestAssured.baseURI = "https://restful-booker.herokuapp.com";
//            ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
//            projectConfiguration.webConfig();
//            projectConfiguration.apiConfig();
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

