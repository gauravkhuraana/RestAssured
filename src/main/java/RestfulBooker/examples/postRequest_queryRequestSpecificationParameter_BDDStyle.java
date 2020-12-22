package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import sun.misc.Request;

public class postRequest_queryRequestSpecificationParameter_BDDStyle {


    @Test
    public void testPostRequest()
    {
        String jsonStr = "{ \"username\":\"admin\" , \"password\" : \"password123\" } ";


        RequestSpecification req=RestAssured.given();

                req.baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .body(jsonStr)
                .contentType(ContentType.JSON)
                .header("header1","username")
                .header("secondHeader","password")
                .log()
                .all();


        QueryableRequestSpecification query = SpecificationQuerier.query(req);

        // get URI
        String URI = query.getURI();
        System.out.println(" URI = "+ URI);

        // get the base URI from Request
        String BaseURI = query.getBaseUri();
        System.out.println(" URI = "+ BaseURI);

        String basePath = query.getBasePath();
        System.out.println(" BasePath is ");

        // get the body from Request
        String body = query.getBody();
        System.out.println("Body "+ body);

        // Get the headers
        Headers allHeaders = query.getHeaders();
        System.out.println("All Headers");

        // This will print some extra
        for(Header h:allHeaders)
        {
            System.out.println(" Header Name =" + h.getName() + " and Header Value = " + h.getValue() );
        }

    }
}
