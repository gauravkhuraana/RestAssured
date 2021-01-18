package headers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class responseSpecification_DRY {

    ResponseSpecification resSpec;
    @BeforeClass
    public void setup()
    {
        resSpec= RestAssured.expect();
        resSpec.statusCode(200);
        resSpec.contentType(ContentType.JSON);
        resSpec.time(Matchers.greaterThan(5000L));
        resSpec.statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void getAllBookings()
    {
        RestAssured
                .given()
                 .baseUri("https://restful-booker.herokuapp.com")
                .when()
                 .get("/booking")
                .then()
                .spec(resSpec)

                // Extra assertion we want which are specific to that test
                .body("size()",Matchers.greaterThan(5));
    }


    @Test
    public void getBookingDetailsWithWrongName()
    {
        RestAssured
                .given()
                  .baseUri("https://restful-booker.herokuapp.com/booking?firstname=2jim")
                .then()
                .spec(resSpec)
                .body("size()",Matchers.equalTo(0));
    }
}
