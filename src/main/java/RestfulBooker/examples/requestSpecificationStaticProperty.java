package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class requestSpecificationStaticProperty {

    @BeforeClass
    public void reqDefaultStatic()
    {
        RequestSpecification req1= RestAssured.given();
                req1.baseUri("https://restful-booker.herokuapp.com");
                req1.basePath("/booking");
        RestAssured.requestSpecification=req1;
    }

    @Test
    public void whenYoujustHaveOneAPIToRun()
    {
        Response res = RestAssured.when().get();
        System.out.println("Response for Default via string   "+res.asString());

    }

    @Test
    public void overrideDefaultSpecification()
    {

        RequestSpecification req2= RestAssured.given();
        req2.baseUri("https://restful-booker.herokuapp.com");
        req2.basePath("/ping");

        Response res = RestAssured.given(req2).get();
        System.out.println("Response when overridden as String "+ res.asString());

        res = RestAssured.with().spec(req2).get();
        System.out.println("Response wwhen passing spec "+ res.asString());


    }
}
