package RestfulBooker.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.*;

public class postRequest_jsonArray_viaSet {


    @Test
    public void javaSet_JsonObjects()
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

        Map<String,Object> json_object2 = new HashMap<String, Object>();

        json_object2.put("firstname","Hari");
        json_object2.put("lastname","bol");
        json_object2.put("depositpaid",false);
        json_object2.put("totalprice",987546);
        json_object2.put("additionalneeds","Dinner");

        Map<String,String> nestedJson_obj2 = new HashMap<String, String>();
        nestedJson_obj2.put("checkin","2021-10-02");
        nestedJson_obj2.put("checkout","2021-10-04");

        json_object2.put("bookingdates",nestedJson_obj2);

        List<Map<String,Object>> jsonArray = new ArrayList<Map<String, Object>>();
        jsonArray.add(json_Objects);
        jsonArray.add(json_object2);


        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(jsonArray)
                .log()
                .all()
             .when()
                .post()
             .then()
                // Intentionally Added since the API does not support jsonArray
                // only one jsonobject is allowed not jsonArray
                .statusCode(500)
                .log()
                .all();



    }

}


