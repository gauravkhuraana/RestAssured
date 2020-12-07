package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class nonBDDStyleRestAssured {

    @Test
    public void GetBookingId_VerifyStatusCode()
    {

        RequestSpecification req = RestAssured.given();
        req.baseUri("https://stackoverflow.com/a/64032620/2986279");

        // Request returns Response type reference
        Response res = req.get();

        String resString = res.asString();
        System.out.println("Response details "+resString);

        // Validatable Response interface can help in validations
        ValidatableResponse vr = res.then();

        vr.statusCode(200);
        vr.statusLine("HTTP/1.1 200 OK");


    }



}
