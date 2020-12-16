package RestfulBooker.examples;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.*;


public class postRequest_serialiaztion_On_content_Type_Basis {


    ObjectMapper fullJson;
    ObjectNode jsonObj;

    @BeforeSuite
    public void javaSet_JsonObjects() {

        fullJson = new ObjectMapper();

        jsonObj= fullJson.createObjectNode();

        jsonObj.put("firstname","Hare");
        jsonObj.put("lastname","Krishna");
        jsonObj.put("additionalneeds","Dinner");
        jsonObj.put("totalprice",98756);
        jsonObj.put ("depositpaid",true);

        ObjectNode jsonNested = fullJson.createObjectNode();
        jsonNested.put("checkin", "2020-12-24");
        jsonNested.put("checkout","2020-12-26");

        jsonObj.set("bookingdates",jsonNested);

      }

    @Test
    public void passingAsJsonBody()
    {
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                // This statement decides which way the input will ho
                .contentType(ContentType.JSON)
                .body(jsonObj)
                .log()
                .all()
                .when()
                .post()
                .then()
                // Intentionally Added since the API does not support jsonArray
                // only one jsonobject is allowed not jsonArray
                .statusCode(200)
                .log()
                .all();
    }
    @Test
    public void passingAsXMLBody()
    {
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")

                // This statement decides which way the input will ho
                   .contentType(ContentType.XML)

                   .body(jsonObj)
                   .log()
                   .all()
                .when()
                    .post()
                .then()
                // Intentionally Added since the API does not support jsonArray
                // only one jsonobject is allowed not jsonArray
                  .statusCode(200)
                   .log()
                    .all();
    }

}


