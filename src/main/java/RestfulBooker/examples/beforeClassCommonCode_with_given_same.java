package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class beforeClassCommonCode_with_given_same {

    RequestSpecification req;

    @BeforeClass
    public void iamTheFirst()
    {
        System.out.println("Before Class ");
        //System.exit(0);
    }

    @BeforeTest()
    public void basicSetup()
{
    req = RestAssured.given();
    req.baseUri("https://restful-booker.herokuapp.com");
    req.basePath("/booking");
    System.out.println("ok test inside " + req);

}

@Test()
    public void TC1()
{
    System.out.println("ok test " + req);
    Response res = req.get();
    ValidatableResponse vres = res.then();
    vres.statusCode(200);
}

    @Test()
    public void TC2()
    {
        RestAssured
                .given()
                .spec(req)
                .when()
                .then()
                .statusCode(200);
    }

    @Test()
    public void TC3()
    {
        RestAssured
                .given(req)
                  .param("FirstName","HareKrishna")
                .when()
                .then()
                .statusCode(200);
    }

    @Test
    public void TC4()
    {
        // used with() instead of given
        RestAssured.with().spec(req).then().statusCode(200);
    }

    @Test
    public void TC5()
    {
        System.out.println("Inside Test 5");
        RestAssured
                // with and given are same
                .with()
                .spec(req)
                .then()
                .statusCode(200);
    }
}


