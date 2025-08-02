package tests;

import io.qameta.allure.Owner;
import models.responses.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("Evgeniya Malysheva")
@DisplayName("Информация по бронированиям")
public class BookingInfoTests extends TestBase {

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
}

