package examples;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class staticRestFul {

    @Test
    public void BDDStyleWithStaticImport()

    {
        // given
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                // when
       .when()
                .get("/booking")
       .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine("HTTP/1.1 200 OK")
               // .body("bookingid",hasSize(10))
                .body("bookingid[3]",equalTo(1));


    }
}
