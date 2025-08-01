package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;

public class BookingSpecs {
    public static RequestSpecification RequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .contentType("application/json");

    public static ResponseSpecification ResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();
}