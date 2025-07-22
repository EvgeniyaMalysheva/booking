package models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookingIdsResponseModel {

    @JsonProperty("bookingid")
    private String bookingId;
}
