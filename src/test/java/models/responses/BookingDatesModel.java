package models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDatesModel {

    @JsonProperty("checkin")
    @Builder.Default
    private LocalDate checkIn = LocalDate.now();

    @JsonProperty("checkout")
    @Builder.Default
    private LocalDate checkOut = LocalDate.now().plusDays(3);

}
