package helpers;

import models.requests.LoginBodyModel;
import models.responses.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static specs.BookingSpecs.RequestSpec;
import static specs.BookingSpecs.ResponseSpec;
import static tests.TestData.*;

public class ApiHelper {

    public String createToken() {
        LoginBodyModel authData = (System.getProperty("login") == null)
                ? new LoginBodyModel(LOGIN, PASSWORD)
                : new LoginBodyModel(System.getProperty("login"), System.getProperty("password"));

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
}
