package examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class postRequest_RestfulBooker_BDDStyle {


    @Test
    public void testPostRequest()
    {
        String jsonStr = "{ \"username\":\"admin\" , \"password\" : \"password123\" } ";

        System.out.println(jsonStr);
        RestAssured
        .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .body(jsonStr)
                .contentType(ContentType.JSON)
        .when()
                .post()


        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("token", Matchers.notNullValue())
                .body("token.length()",Matchers.is(15))
                .body("token",Matchers.matchesRegex("[a-z0-9]+"));



    }
}
