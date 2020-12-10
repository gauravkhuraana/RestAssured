package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class putRequest_RestfulBooker_BDDStyle {


    @Test
    public void testPostRequest()
    {
        String jsonStr ="{\"firstname\":\"Hare\",\"lastname\":\"Krishna\",\"totalprice\":765,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2019-08-03\",\"checkout\":\"2020-02-27\"}}";


        System.out.println(jsonStr);
        RestAssured
        .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .body(jsonStr)
                .contentType(ContentType.JSON)
                .cookie("token","48edd9957a3749b")
        .when()
                .put()


        .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
                //.body("firstname", Matchers.notNullValue())
               // .body("depositpaid",Matchers.equalTo(false));
               // .body("bookingdates.checkin",Matchers.notNullValue());

      //  getRequest_RestfulBroker_nonBDDStyle.main(new String[]{"Hello","Krishna"});

    }
}
