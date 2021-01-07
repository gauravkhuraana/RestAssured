package examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class postRequest_using_JavaMap {

    @Test
    public void javaMapInJson()
    {

        Map<String,String> jsonInput = new HashMap<String,String >();
        jsonInput.put("username","admin");
        jsonInput.put("password","password123");


        RestAssured
             .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(jsonInput)
                .log()
                .all()
            // .when()
                .post()
             .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void javaMap_JsonObjects()
    {
        Map<String, Object> json_Objects = new HashMap<String, Object>();

        json_Objects.put("firstname","Hare");
        json_Objects.put("additionalneeds","Dinner");
        json_Objects.put("totalprice",25634);
        json_Objects.put("depositpaid",true);
        json_Objects.put("lastname","Krishna");
        json_Objects.put("firstName","Hare");

        Map<String,String> nestedJson_Obj = new HashMap<String, String>();
        nestedJson_Obj.put("checkin","2021-09-01");
        nestedJson_Obj.put("checkout","2021-09-05");

        json_Objects.put("bookingdates",nestedJson_Obj);

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(json_Objects)
                .log()
                .all()
             .when()
                .post()
             .then()
                .statusCode(200)
                .log()
                .all();



    }

}


