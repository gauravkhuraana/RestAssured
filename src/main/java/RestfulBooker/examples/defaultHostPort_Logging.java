package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import sun.misc.Request;

public class defaultHostPort_Logging {

    @Test
    public void defaultTest()
    {
        RestAssured.given()
                  // logging all details
                    .log()
                    .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .port(8181)
                .when()
                    .get()
        .then()
            .statusCode(200);
    }

    @Test
    public void usingRequestSpecificationBuilder()
    {
        RequestSpecBuilder rsb = new RequestSpecBuilder();
        rsb.setBaseUri("https://restful-booker.herokuapp.com");
        rsb.setBasePath("/ping");
        rsb.setPort(8181);


        RequestSpecification req = rsb.build();

        Response res = RestAssured.given().spec(req)
                .when()
                .get();
    }

    @Test
    public void staticPortProperty()
    {
        RestAssured.port=9191;
        RestAssured.given().log().all().when().get().then().statusCode(200);

    }
}
