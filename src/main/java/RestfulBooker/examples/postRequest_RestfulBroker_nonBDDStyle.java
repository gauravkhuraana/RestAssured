package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class postRequest_RestfulBroker_nonBDDStyle {

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

        // Then
        ValidatableResponse vres = res.then();

        // Extract data and validate
        vres.statusCode(200);
        vres.body("token", Matchers.notNullValue());
        vres.body("token.length()",Matchers.is(15));
        vres.body("token",Matchers.matchesRegex("^[a-z0-9]+$"));






    }

}


