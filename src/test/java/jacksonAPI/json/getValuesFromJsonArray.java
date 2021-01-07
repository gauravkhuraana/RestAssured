package jacksonAPI.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

public class getValuesFromJsonArray {

    String jsonArray=" [\n" +
            "    {\n" +
            "      \"firstName\": \"Amod\",\n" +
            "      \"lastName\": \"Mahajan\",\n" +
            "      \"age\": 28,\n" +
            "      \"isMarried\": false,\n" +
            "      \"salary\": 23456.54\n" +
            "    },\n" +
            "    {\n" +
            "      \"firstName\": \"Rahul\",\n" +
            "      \"lastName\": \"Arora\",\n" +
            "      \"age\": 32,\n" +
            "      \"isMarried\": true,\n" +
            "      \"salary\": 33456.54\n" +
            "    }\n" +
            "  ],\n" +
            "  [\n" +
            "    {\n" +
            "      \"firstName\": \"Amod\",\n" +
            "      \"lastName\": \"Mahajan\",\n" +
            "      \"age\": 28,\n" +
            "      \"isMarried\": false,\n" +
            "      \"salary\": 23456.54\n" +
            "    },\n" +
            "    {\n" +
            "      \"firstName\": \"Rahul\",\n" +
            "      \"lastName\": \"Arora\",\n" +
            "      \"age\": 32,\n" +
            "      \"isMarried\": true,\n" +
            "      \"salary\": 33456.54\n" +
            "    }\n" +
            "  ]\n" +
            "]";

    String firstName;
    String lastName;
    int age;
    boolean married;
    double salary;


    @Test
    public void jsonArray() throws JsonProcessingException {
        ObjectMapper objMap = new ObjectMapper();

      //  objMap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        JsonNode jsN = objMap.readTree(jsonArray);

           // to check if the subnode is JsonObject or JsonArray

        System.out.println(" is this an Json Object "+ Boolean.toString(jsN instanceof ObjectNode));
        System.out.println(" is this an Json Array "+ Boolean.toString(jsN instanceof ArrayNode));

        JsonNode firstJson = jsN.get(0);
        JsonNode secondJson = jsN.get(1);

        firstName=firstJson.get("firstName").asText();

        // Used path since we dont have secondName
        lastName=firstJson.path("secondName").asText();
        age=firstJson.get("age").asInt();
        married=firstJson.get("isMarried").asBoolean();
        salary=firstJson.get("salary").asInt();

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(age);
        System.out.println(married);
        System.out.println(salary);

        firstName=secondJson.get("firstName").asText();
        lastName=secondJson.path("secondName").asText();
        age=secondJson.get("age").asInt();
        married=secondJson.get("isMarried").asBoolean();
        salary=secondJson.get("salary").asInt();

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(age);
        System.out.println(married);
        System.out.println(salary);

    }
}
