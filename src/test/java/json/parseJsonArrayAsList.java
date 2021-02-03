package json;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class parseJsonArrayAsList {

    @Test
            public void jsonArray() {
        List<Map<String, Object>> response = null;


        response =
                RestAssured
                        .given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("booking")
                        .when()
                        .get()
                        .then()
                        .extract()
                        .body()
                        .as(new TypeRef<List<Map<String, Object>>>() {
                        });

        System.out.println("Total bookings : "+ response.size());

        System.out.println(" All bookings ids are ");

        for (Map<String,Object> booking : response )
        {
            System.out.println(booking.get("bookingid"));
        }

    }



}
