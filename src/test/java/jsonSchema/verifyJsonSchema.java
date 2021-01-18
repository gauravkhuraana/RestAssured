package jsonSchema;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.awt.geom.RectangularShape;
import java.io.File;

public class verifyJsonSchema {


    @Test
    public void validateJson() {
        String jsonStr = "{\"username\":\"admin\",\n" +
                "\"password\":\"password123\"}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(jsonStr)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AuthJsonSchema.json"));

    }

    @Test
    public void validateJsonWithFullSchemaPath() {
        String jsonStr = "{\"username\":\"admin\",\n" +
                "\"password\":\"password123\"}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(jsonStr)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
                .body(JsonSchemaValidator.matchesJsonSchema(new File("S:\\Automation\\RestAssured\\src\\test\\resources\\AuthJsonSchema.json")));

    }
}
