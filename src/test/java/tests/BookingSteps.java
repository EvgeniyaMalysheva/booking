package tests;

import io.qameta.allure.Step;
import models.requests.LoginBodyModel;
import models.responses.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.*;
import static org.junit.jupiter.api.Assertions.*;
import static specs.BookingSpecs.RequestSpec;
import static specs.BookingSpecs.ResponseSpec;
import static tests.TestData.*;

public class BookingSteps {

    public String createToken() {
        LoginBodyModel authData = (System.getProperty("restLogin") == null)
                ? new LoginBodyModel(LOGIN, PASSWORD)
                : new LoginBodyModel(System.getProperty("restLogin"), System.getProperty("restPass"));

        LoginResponseModel token = given(RequestSpec)
                .body(authData)
                .when()
                .post(GENERATE_TOKEN_END_POINT)
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_OK)
                .extract().as(LoginResponseModel.class);

        return token.getToken();
    }

    @Step("Запрос всех существующих ID бронирований")
    public List<BookingIdsResponseModel> getBookingIds() {

        List<BookingIdsResponseModel> bookingIds = given(RequestSpec)
                .when()
                .get(BOOKING_END_POINT)
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_OK)
                .extract()
                .body()
                .jsonPath()
                .getList(".", BookingIdsResponseModel.class);

        assertFalse(bookingIds.isEmpty(), "Список бронирований должен быть непустым");
        return bookingIds;
    }

    @Step("Запрос информации по существующему id бронирования")
    public BookingModel getExistingBookingById() {
        List<BookingIdsResponseModel> listOfBookings = getBookingIds();
        int id = Integer.parseInt(listOfBookings.get(0).getBookingId());
        return given(RequestSpec)
                .when()
                .pathParam("id", id)
                .get(BOOKING_END_POINT + "/{id}")
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_OK)
                .extract().as(BookingModel.class);
    }

    @Step("Запрос информации по существующему id бронирования")
    public int getExistingBookingId() {
        List<BookingIdsResponseModel> listOfBookings = getBookingIds();
        return Integer.parseInt(listOfBookings.get(0).getBookingId());
    }

    @Step("Запрос информации по существующему id бронирования")
    public BookingModel getBookingById(int id) {
        return given(RequestSpec)
                .when()
                .pathParam("id", id)
                .get(BOOKING_END_POINT + "/{id}")
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_OK)
                .extract().as(BookingModel.class);
    }

    @Step("Запрос информации по несуществующему id бронирования")
    public void get404ForNotExistingBooking(int id) {
        given(RequestSpec)
                .when()
                .pathParam("id", id)
                .get(BOOKING_END_POINT + "/{id}")
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_NOT_FOUND);
    }

    @Step("Проверка на непустые значения полей")
    public void checkBookingDataIsNotNull(BookingModel bookingData) {
        assertNotNull(bookingData.getFirstName(), "Объект не должен быть null");
        assertNotNull(bookingData.getLastName(), "Объект не должен быть null");
        assertNotNull(bookingData.getBookingDates(), "Объект не должен быть null");
        assertNotNull(bookingData.getAdditionalNeeds(), "Объект не должен быть null");
    }

    @Step("Создание бронирования")
    public CreateBookingResponseModel createBooking(BookingModel newBookingData) {
        return given(RequestSpec)
                .body(newBookingData)
                .when()
                .post(BOOKING_END_POINT)
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_OK)
                .extract().as(CreateBookingResponseModel.class);
    }

    @Step("Проверка данных нового бронирования")
    public void checkBookingData
            (BookingModel newBookingDataValue,
             CreateBookingResponseModel responseValue) {
        assertNotNull(responseValue, "Объект не должен быть null");
        assertEquals(newBookingDataValue, responseValue.getBooking(), "Данные не совпадают");
        assertTrue(responseValue.getBookingId() > 0, "Некорректный BookingId");
    }

    @Step("Получение id для удаления бронирования")
    public int getBookingIdForDelete(BookingModel newBooking) {
        CreateBookingResponseModel response = createBooking(newBooking);
        return response.getBookingId();
    }

    @Step("Удаление бронирования")
    public BookingSteps deleteBookingData(int id) {
        String tokenValue = createToken();
        given(RequestSpec)
                .when()
                .header("Cookie", "token=" + tokenValue)
                .pathParam("id", id)
                .delete(BOOKING_END_POINT + "/{id}")
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_CREATED);

        return this;
    }

    @Step("Пингуем сервис")
    public void pingService() {
        given(RequestSpec)
                .when()
                .get(PING_END_POINT)
                .then()
                .spec(ResponseSpec)
                .statusCode(HTTP_CREATED);
    }


}

