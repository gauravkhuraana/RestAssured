package examples;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BDDStyleCode {


    @Test
    public void getBookingID_VerifyStatusCode()
    {
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
        .when()
                .get("/booking")
        .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("bookingid[3]",Matchers.equalTo(1))
                .body("bookingid.sum()", Matchers.hasSize(136));
        System.out.println("hello how are you ");
        Assert.assertEquals(true,false);


    }
}
