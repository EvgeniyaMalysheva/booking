package tests;

import io.qameta.allure.Owner;
import models.responses.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("Evgeniya Malysheva")
public class BookingTests extends TestBase {

    @Test
    @DisplayName("TC_API_1: Запрос списка всех бронирований")
    void getAllExistingBookingIdsTest() {
        newBooking.getBookingIds();
    }

    @Test
    @DisplayName("TC_API_2: Запрос подробной информации по одному бронированию")
    void getBookingByIdTest() {
        BookingModel booking = newBooking.getBookingById
                (newBooking.getExistingBookingId());
        newBooking.checkBookingDataIsNotNull(booking);
    }

    @Test
    @DisplayName("TC_API_3: Создание нового бронирования")
    void createBookingTest() {
        CreateBookingResponseModel response =
                newBooking.createBooking(newBookingData);
        newBooking.checkBookingData(newBookingData, response);
    }

    @Test
    @DisplayName("TC_API_4: Удаление  бронирования")
    void deleteBookingTest() {
        int deleteBookingId = newBooking.getBookingIdForDelete(newBookingData);
        newBooking.deleteBookingData(deleteBookingId)
                .get404ForNotExistingBooking(deleteBookingId);
    }

    @Test
    @DisplayName("TC_API_5: Проверка работоспособности (ping) сервиса")
    void HealthCheckTest() {
        newBooking.pingService();
    }


}

