package headers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class setContentTypeForREquest {


    @Test
    public void withoutSettingContentType()
    {
        RestAssured
                .given()
                .log()
                .all()
                .body("{\r\n" +
                        "    \"firstname\" : \"Jim\",\r\n" +
                        "    \"lastname\" : \"Brown\",\r\n" +
                        "    \"totalprice\" : 111,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2018-01-01\",\r\n" +
                        "        \"checkout\" : \"2019-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .log()
                .all();


    }

    @Test
    public void settingContentType()
    {
        RestAssured
                .given()
                .log()
                .all()

                .header("Content-Type","application/json")

                // The above one you can do spelling mistake
                .contentType(ContentType.JSON)
                .body("{\r\n" +
                        "    \"firstname\" : \"Jim\",\r\n" +
                        "    \"lastname\" : \"Brown\",\r\n" +
                        "    \"totalprice\" : 111,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2018-01-01\",\r\n" +
                        "        \"checkout\" : \"2019-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .log()
                .all();


    }



}
