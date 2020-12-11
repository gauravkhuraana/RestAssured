package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class variousWaysOfRunningRestRequest {

    @Test
    public void waysOfRestRequest()
    {
        RequestSpecification req = RestAssured.given();

                req.baseUri("https://restful-booker.herokuapp.com");
                req.basePath("/booking");

                Response res1 = req.get();
                System.out.println(res1.asString());

                Response res2 = RestAssured.given().spec(req).get();
                System.out.println(res2.asString());

                Response res3 = RestAssured.given(req).get();
                System.out.println(res3.asString());



    }
}
