package json;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Map;

public class parseJsonObjectToMap {

    @Test
    public void convertJsonObjToMap() {


        Map<String,Object> response = null;

        response = RestAssured
                .given()
                 .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking")
                .contentType(ContentType.JSON)
                .body("{\r\n" +
                        "    \"firstname\" : \"Gaurav\",\r\n" +
                        "    \"lastname\" : \"Khurana\",\r\n" +
                        "    \"totalprice\" : 111,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2018-01-01\",\r\n" +
                        "        \"checkout\" : \"2019-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .when()
                .post()
        .then()
        .extract()
        .body()
        .as(new TypeRef<Map<String, Object>>() {});

        // To print bookingId
    System.out.println("Booking id is "+response.get("bookingid"));

    @SuppressWarnings("unchecked")
            Map<String, Object > bookingDetails = (Map<String, Object>) response.get("booking");
            System.out.println("First name is "+ bookingDetails.get("firstname"));


    }



}
