package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class patchRequest_RestfulBooker_BDDStyle {


    @Test
    public void testPostRequest()
    {
        String jsonStr ="{\"firstname\":\"HAri Bol\", \"lastname\":\"Krishna\"}";
        System.out.println(jsonStr);

        RestAssured
        .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .body(jsonStr)
                .contentType(ContentType.JSON)
                .cookie("token","8ad00cca117c038")
        .when()
                .patch()


        .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
                //.body("firstname", Matchers.notNullValue())
               // .body("depositpaid",Matchers.equalTo(false));
               // .body("bookingdates.checkin",Matchers.notNullValue());

        getRequest_RestfulBroker_nonBDDStyle.main(new String[]{"Hello","Krishna"});

    }
}
