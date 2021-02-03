package examples;

import io.restassured.RestAssured;
import javafx.scene.paint.Material;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class assetFullBodyResponse {

    @Test
    public void assertFullResponse()
    {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://gorest.co.in")
                .basePath("/public-api/users/{id}")
                .pathParam("id","178")
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .body(Matchers.equalTo("{\n" +
                        "    \"code\": 200,\n" +
                        "    \"meta\": null,\n" +
                        "    \"data\": {\n" +
                        "        \"id\": 178,\n" +
                        "        \"name\": \"Puneet Rana\",\n" +
                        "        \"email\": \"rana_puneet@trantow.org\",\n" +
                        "        \"gender\": \"Male\",\n" +
                        "        \"status\": \"Inactive\",\n" +
                        "        \"created_at\": \"2021-02-03T03:50:07.588+05:30\",\n" +
                        "        \"updated_at\": \"2021-02-03T03:50:07.588+05:30\"\n" +
                        "    }\n" +
                        "}"));

    }


    @Test
    public void matchingViExternalFile() throws IOException {

                 RestAssured
                         .given()
                         .log()
                         .all()
                         .baseUri("https://gorest.co.in/public-api/")
                         .basePath("users/{id}")
                         .pathParam("id","178")
                         .when()
                         .get()
                         .then()
                         .log()
                         .all()
                         .assertThat()
                         .body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\test\\resources\\output.json")))));


    }
}
