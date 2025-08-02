package tests;

import io.qameta.allure.Owner;
import models.responses.CreateBookingResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("Evgeniya Malysheva")
@DisplayName("Управление бронированиями")
public class BookingProcessTests extends TestBase{

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
}
