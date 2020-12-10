package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class getRequest_RestfulBroker_nonBDDStyle {

    public static void main(String[] args)
    {

        // Request Details
        RequestSpecification req = RestAssured.given();

        // Request extras
        req.contentType(ContentType.JSON);
        req.baseUri("https://restful-booker.herokuapp.com/booking/3");


        // Verb
        Response res = req.get();

        // Print Response
        System.out.println(res.asString());

        // Then
        ValidatableResponse vres = res.then();

        // Extract data and validate
        vres.statusCode(200);
            vres.body("firstname", Matchers.notNullValue());
         //   vres.body("depositpaid",Matchers.equalTo(false));
        // .body("bookingdates.checkin",Matchers.notNullValue());






    }

}


