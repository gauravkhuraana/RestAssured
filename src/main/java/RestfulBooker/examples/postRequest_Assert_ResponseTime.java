package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

public class postRequest_Assert_ResponseTime {

    public static void main(String[] args)
    {
        String jsonString = "{" +
                "   \"username\" : \"admin\"," +
                "    \"password\" : \"password123\" } ";
        System.out.println(jsonString);

        // Request Details
        RequestSpecification req = RestAssured.given();

        // Request extras
        req.contentType(ContentType.JSON);
        req.baseUri("https://restful-booker.herokuapp.com/auth");
        req.body(jsonString);

        // Verb
        Response res = req.post();

        // Print Response
        System.out.println(res.asString());

        // Matchers does not work for Response
        long resTime = res.getTime();
        long resTime2 = res.getTimeIn(TimeUnit.MICROSECONDS);

        System.out.println("Time taken = default       "+ resTime);
        System.out.println("Time taken in Microseconds "+ resTime2);

        long resTime3 = res.time();
        long resTime4 = res.timeIn(TimeUnit.MINUTES);

        System.out.println("Time taken = default       "+ resTime3);
        System.out.println("Time taken in Minutes "+ resTime4);

        // Then
        ValidatableResponse vres = res.then();

        // Matchers only work for ValidatableResponse
        vres.time(Matchers.lessThan(20000L));
        vres.time(Matchers.greaterThan(200L));
        vres.time(Matchers.both(Matchers.greaterThanOrEqualTo(200L)).and(Matchers.lessThan(20000L)));
        vres.time(Matchers.lessThanOrEqualTo(1L),TimeUnit.MINUTES);




        // Extract data and validate
        vres.statusCode(200);
        vres.body("token", Matchers.notNullValue());
        vres.body("token.length()",Matchers.is(15));
        vres.body("token",Matchers.matchesRegex("^[a-z0-9]+$"));






    }

}


