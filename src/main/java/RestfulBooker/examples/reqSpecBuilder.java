package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class reqSpecBuilder {

    @Test
    public void requestSpecBuilder()
    {
        RequestSpecBuilder requestSpec = new RequestSpecBuilder();
        requestSpec.setBaseUri("https://restful-booker.herokuapp.com");
        requestSpec.setBasePath("/booking");

        RequestSpecification req = requestSpec.build();

        Response res1 = req.get();
        Response res2 = RestAssured.given().spec(req).get();
        Response res3 = RestAssured.given(req).get();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }
}
