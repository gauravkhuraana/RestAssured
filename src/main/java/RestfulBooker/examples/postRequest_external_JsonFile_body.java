package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class postRequest_external_JsonFile_body {


    @Test
    public void testPostRequest()
    {

        File jsonInput = new File("src/main/resources/payloads/AuthPayLoadJson.json");

        RestAssured
        .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .body(jsonInput)
                .contentType(ContentType.JSON)
                .log()
                .all()
        .when()
                .post()


        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("token", Matchers.notNullValue())
                .body("token.length()",Matchers.is(15))
                .body("token",Matchers.matchesRegex("^[a-z0-9]+$"))
                .log()
                .all();


    }
}
