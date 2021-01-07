package jacksonAPI.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class get_path_Methods_toGetValue {

    String jsonStr ="{\n" +
            "  \"array\": [\n" +
            "    1,\n" +
            "    2,\n" +
            "    3\n" +
            "  ],\n" +
            "  \"boolean\": true,\n" +
            "  \"color\": \"gold\",\n" +
            "  \"null\": null,\n" +
            "  \"number\": 123,\n" +
            "  \"skills\": {\n" +
            "    \"java\": \"Intermediate\",\n" +
            "    \"selenium\": \"Expert\",\n" +
            "    \"restAssured\":\"Beginner\"\n" +
            "  },\n" +
            "  \"string\": \"Hello World\"\n" +
            "}";
    @Test
    public void getMethodToGetValues() throws JsonProcessingException {
        String jsonStr="{\n" +
                "  \"array\": [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3\n" +
                "  ],\n" +
                "  \"boolean\": true,\n" +
                "  \"color\": \"gold\",\n" +
                "  \"null\": null,\n" +
                "  \"number\": 123,\n" +
                "  \"object\": {\n" +
                "    \"a\": \"b\",\n" +
                "    \"c\": \"d\"\n" +
                "  },\n" +
                "  \"string\": \"Hello World\"\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();
        JsonNode jsN = objMap.readTree(jsonStr);

        boolean firstName = jsN.get("boolean").asBoolean();
        String color = jsN.get("color").asText();
        String NULL = jsN.get("null").asText();


        // Will be converted to int from String
        Integer number = jsN.get("color").asInt();

        String obj = jsN.get("object1").asText();


        System.out.println(firstName);
        System.out.println(color);
        System.out.println(NULL);
        System.out.println(number);

        // Will give error as object1 is non existing
        System.out.println(obj);

    }

    @Test
    public void pathMethod() throws JsonProcessingException {
       String jsonStr = "{\n" +
               "  \"array\": [\n" +
               "    1,\n" +
               "    2,\n" +
               "    3\n" +
               "  ],\n" +
               "  \"boolean\": true,\n" +
               "  \"color\": \"gold\",\n" +
               "  \"null\": null,\n" +
               "  \"number\": 123,\n" +
               "  \"object\": {\n" +
               "    \"a\": \"b\",\n" +
               "    \"c\": \"d\"\n" +
               "  },\n" +
               "  \"string\": \"Hello World\"\n" +
               "}";

       ObjectMapper objMap = new ObjectMapper();
       JsonNode jsN = objMap.readTree(jsonStr);

       // Trying to get something non existing
       String color = jsN.path("firstname").asText("Default value");
       System.out.println("Color " + color);



    }

    @Test
    public void methodChaining() throws JsonProcessingException {


        ObjectMapper objMap = new ObjectMapper();
        JsonNode jsN = objMap.readTree(jsonStr);

        String java = jsN.get("skills").get("java").asText();
        String maven = jsN.get("skills").path("maven").asText("Default value");

        System.out.println(java);
        System.out.println(maven);

    }

    @Test
    public void at() throws JsonProcessingException {
        ObjectMapper objMap = new ObjectMapper();
        JsonNode jsN = objMap.readTree(jsonStr);
        String java = jsN.at("/skills/Java").asText();
        System.out.println(java);


    }


}
