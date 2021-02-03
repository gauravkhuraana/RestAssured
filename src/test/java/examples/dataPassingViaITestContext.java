package examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class dataPassingViaITestContext {


    @Test
    public void createBooking(ITestContext context)
    {
        int bookingId =
                RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking")
                .contentType(ContentType.JSON)
                .body("{                      \"firstname\" : \"Jim\",\n" +
                        "                        \"lastname\" : \"Brown\",\n" +
                        "                        \"totalprice\" : 111,\n" +
                        "                        \"depositpaid\" : true,\n" +
                        "                        \"bookingdates\" : {\n" +
                        "                            \"checkin\" : \"2018-01-01\",\n" +
                        "                            \"checkout\" : \"2019-01-01\"\n" +
                        "                        },\n" +
                        "                        \"additionalneeds\" : \"Breakfast\"}\n" +
                        "                       ")
                .when()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .jsonPath()
                .get("bookingid");
        context.setAttribute("bookingId",bookingId);
    }

    @Test
    public void updateBooking(ITestContext context)
    {
        int bookingId = (int) context.getAttribute("bookingId");

        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .basePath("booking/"+bookingId)
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .body("{\r\n" +
                        "    \"firstname\" : \"Gaurav\",\r\n" +
                        "    \"lastname\" : \"Khurana\",\r\n" +
                        "    \"totalprice\" : 222,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2022-01-01\",\r\n" +
                        "        \"checkout\" : \"2022-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .when()
                .put()
                .then()
                .log()
                .all();
    }
}
