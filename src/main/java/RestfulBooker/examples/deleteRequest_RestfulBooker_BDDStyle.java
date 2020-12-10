package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class deleteRequest_RestfulBooker_BDDStyle {


    @Test
    public void testDeleteRequest()
    {
        RestAssured
        .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/3")
                .cookie("token","34d5015dad81aed")
        .when()
                .delete()


        .then()
                .assertThat()
                .statusCode(201)
                .statusLine("HTTP/1.1 201 Created");
                //.body("firstname", Matchers.notNullValue())
               // .body("depositpaid",Matchers.equalTo(false));
               // .body("bookingdates.checkin",Matchers.notNullValue());
        System.out.println("Now calling get Request");
        getRequest_RestfulBroker_nonBDDStyle.main(new String[]{"Hello","Krishna"});

    }
}
