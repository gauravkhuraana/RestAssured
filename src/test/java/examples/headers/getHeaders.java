package examples.headers;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class getHeaders {


    @Test
    public void variousHeaderSetRestAssured()
    {
        Response res = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\\r\\n\" + \n" +
                        "\t\t\t\t\"    \\\"firstname\\\" : \\\"Jim\\\",\\r\\n\" + \n" +
                        "\t\t\t\t\"    \\\"lastname\\\" : \\\"Brown\\\",\\r\\n\" + \n" +
                        "\t\t\t\t\"    \\\"totalprice\\\" : 111,\\r\\n\" + \n" +
                        "\t\t\t\t\"    \\\"depositpaid\\\" : true,\\r\\n\" + \n" +
                        "\t\t\t\t\"    \\\"bookingdates\\\" : {\\r\\n\" + \n" +
                        "\t\t\t\t\"        \\\"checkin\\\" : \\\"2018-01-01\\\",\\r\\n\" + \n" +
                        "\t\t\t\t\"        \\\"checkout\\\" : \\\"2019-01-01\\\"\\r\\n\" + \n" +
                        "\t\t\t\t\"    },\\r\\n\" + \n" +
                        "\t\t\t\t\"    \\\"additionalneeds\\\" : \\\"Breakfast\\\"\\r\\n\" + \n" +
                        "\t\t\t\t\"}")
                .post("https://restful-booker.herokuapp.com/booking");

        String contentType = res.contentType();
        System.out.println("content type via contentType() "+contentType);
        // above and this both are just the same
        contentType=res.getContentType();
        System.out.println("contetn type via getContentType() " +contentType);

        // Another way
        contentType=res.getHeader("content-type with getheader method");
        System.out.println("ContentType "+contentType);

    }

    @Test
    public void testHeaderAssertion()
    {
        RestAssured
        .given()
         .contentType(ContentType.JSON)
         .body("{\\r\\n\" + \n" +
                 "\t\t\t\t\"    \\\"firstname\\\" : \\\"Jim\\\",\\r\\n\" + \n" +
                 "\t\t\t\t\"    \\\"lastname\\\" : \\\"Brown\\\",\\r\\n\" + \n" +
                 "\t\t\t\t\"    \\\"totalprice\\\" : 111,\\r\\n\" + \n" +
                 "\t\t\t\t\"    \\\"depositpaid\\\" : true,\\r\\n\" + \n" +
                 "\t\t\t\t\"    \\\"bookingdates\\\" : {\\r\\n\" + \n" +
                 "\t\t\t\t\"        \\\"checkin\\\" : \\\"2018-01-01\\\",\\r\\n\" + \n" +
                 "\t\t\t\t\"        \\\"checkout\\\" : \\\"2019-01-01\\\"\\r\\n\" + \n" +
                 "\t\t\t\t\"    },\\r\\n\" + \n" +
                 "\t\t\t\t\"    \\\"additionalneeds\\\" : \\\"Breakfast\\\"\\r\\n\" + \n" +
                 "\t\t\t\t\"}")
         .post("https://restful-booker.herokuapp.com/booking")
        .then()
                // asserting content type
            .contentType(ContentType.TEXT);


    }
}
