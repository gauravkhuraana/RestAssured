package examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

public class postRequest_external_XMLFile_body {


    @Test
    public void testPostRequest()
    {

        File XMLInput = new File("src/main/resources/payloads/AuthPayLoadXml.xml");

        RestAssured
        .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .body(XMLInput)
                .contentType(ContentType.XML)
                .log()
                .all()
        .when()
                .post()


        .then()
                .statusCode(200)
                .log()
                .all();



    }
}
