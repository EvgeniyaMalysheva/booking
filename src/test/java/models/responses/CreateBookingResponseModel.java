package models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateBookingResponseModel {
    @JsonProperty("bookingid")
    private int bookingId;

    private BookingModel booking;

}
