package models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static utils.RandomUtils.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingModel {
    @JsonProperty("firstname")
    @Builder.Default
    private String firstName = getRandomFirstName();

    @JsonProperty("lastname")
    @Builder.Default
    private String lastName = getRandomLastName();

    @JsonProperty("totalprice")
    @Builder.Default
    private int totalPrice = getRandomPrice();

    @JsonProperty("depositpaid")
    @Builder.Default
    private boolean depositPaid = getRandomBoolean();

    @JsonProperty("bookingdates")
    @Builder.Default
    private BookingDatesModel bookingDates = BookingDatesModel.builder().build();

    @JsonProperty("additionalneeds")
    @Builder.Default
    private String additionalNeeds = getRandomAdditionalNeeds();
}
