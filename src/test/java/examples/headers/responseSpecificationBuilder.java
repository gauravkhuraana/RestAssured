package examples.headers;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class responseSpecificationBuilder {


    ResponseSpecification resSpec;

    @BeforeClass
    public void setupResponseSpec()
    {
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

    }

    @Test
    public void getAllBooking()
    {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .then()
                .spec(resSpec)
                .body("size()",Matchers.greaterThan(5));
    }

    @Test
    public void getBookingDetails()
    {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking?firstname=jim")
                .then()
                .spec(resSpec)
                .body("size()",Matchers.equalTo(0));
    }


}
