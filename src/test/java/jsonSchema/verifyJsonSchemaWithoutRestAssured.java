package jsonSchema;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class verifyJsonSchemaWithoutRestAssured {

    @Test
    public void noRestAssured()
    {
        String jsonStr = "      {\n" +
                "            \"firstname\": \"Jim\",\n" +
                "            \"lastname\": \"Brown\",\n" +
                "            \"totalprice\": 111,\n" +
                "            \"depositpaid\": true,\n" +
                "            \"bookingdates\": {\n" +
                "                \"checkin\": \"2018-01-01\",\n" +
                "                \"checkout\": \"2019-01-01\"\n" +
                "            },\n" +
                "            \"additionalneeds\": \"Breakfast\"\n" +
                "        }";


        MatcherAssert.assertThat(jsonStr, JsonSchemaValidator.matchesJsonSchemaInClasspath("AuthJsonSchema_SchemaFile.JSON"));
    }
}
