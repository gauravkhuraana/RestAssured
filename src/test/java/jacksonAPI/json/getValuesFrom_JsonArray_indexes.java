package jacksonAPI.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

public class getValuesFrom_JsonArray_indexes {

    String jsonArray="[\r\n" +
            "  {\r\n" +
            "    \"firstName\": \"Hare\",\r\n" +
            "    \"lastName\": \"Krishna\",\r\n" +
            "    \"address\": [\r\n" +
            "      {\r\n" +
            "        \"type\": \"Permanent\",\r\n" +
            "        \"city\": \"Telangana\",\r\n" +
            "        \"state\": \"Karnataka\"\r\n" +
            "      },\r\n" +
            "      {\r\n" +
            "        \"type\": \"Communication\",\r\n" +
            "        \"city\": \"Katihar\",\r\n" +
            "        \"state\": \"Bihar\"\r\n" +
            "      }\r\n" +
            "    ]\r\n" +
            "  },\r\n" +
            "  {\r\n" +
            "    \"firstName\": \"Hari\",\r\n" +
            "    \"lastName\": \"Bol\",\r\n" +
            "    \"address\": [\r\n" +
            "      {\r\n" +
            "        \"type\": \"Permanent\",\r\n" +
            "        \"city\": \"Delhi\",\r\n" +
            "        \"state\": \"Delhi\"\r\n" +
            "      },\r\n" +
            "      {\r\n" +
            "        \"type\": \"Communication\",\r\n" +
            "        \"city\": \"Indore\",\r\n" +
            "        \"state\": \"MP\"\r\n" +
            "      }\r\n" +
            "    ]\r\n" +
            "  }\r\n" +
            "]";

     String  numberAsKey="[ {\n" +
             "    \"firstName\": \"Amod\",\n" +
             "    \"lastName\": \"Mahajan\",\n" +
             "    \"address\": [\n" +
             "      {\n" +
             "        \"0\": \"Permanent\",\n" +
             "        \"1\": \"Bengaluru\",\n" +
             "        \"2\": \"Karnataka\"\n" +
             "      },\n" +
             "      {\n" +
             "        \"0\": \"Communication\",\n" +
             "        \"1\": \"Katihar\",\n" +
             "        \"2\": \"Bihar\"\n" +
             "      }\n" +
             "    ]\n" +
             "  },\n" +
             "  {\n" +
             "    \"firstName\": \"Animesh\",\n" +
             "    \"lastName\": \"Prashant\",\n" +
             "    \"address\": [\n" +
             "      {\n" +
             "        \"0\": \"Permanent\",\n" +
             "        \"1\": \"Delhi\",\n" +
             "        \"2\": \"Delhi\"\n" +
             "      },\n" +
             "      {\n" +
             "        \"0\": \"Communication\",\n" +
             "        \"1\": \"Indore\",\n" +
             "        \"2\": \"MP\"\n" +
             "      }\n" +
             "    ]\n" +
             "  }\n" +
             "]";


    @Test
    public void jsonArray() throws JsonProcessingException {

        ObjectMapper objMap = new ObjectMapper();


        JsonNode jsN = objMap.readTree(jsonArray);

     // Using Get Method

        System.out.println(jsN.get(0).get("firstName").asText());
        System.out.println(jsN.get(0).get("address").get(0).get("type").asText());

    // Using at method

        System.out.println(jsN.at("/0/firstName").asText());
        System.out.println(jsN.at("/0/address/0/type").asText());
        System.out.println(jsN.at("/0/address/1/type").asText());

        System.out.println("Searching for second ");
        System.out.println(jsN.at("/1/firstName").asText());
        System.out.println(jsN.at("/1/address/0/type").asText());
        System.out.println(jsN.at("/1/address/1/type").asText());


        JsonNode jsNo = objMap.readTree(numberAsKey);

        System.out.println("When keys are numbers ");
        System.out.println(jsNo.at("/0/firstName").asText());
        System.out.println(jsNo.at("/0/address/0/0").asText());
        System.out.println(jsNo.at("/0/address/1/0").asText());

        System.out.println("Things from second index ");
        System.out.println(jsNo.at("/1/firstName").asText());
        System.out.println(jsNo.at("/1/address/0/0").asText());
        System.out.println(jsNo.at("/1/address/1/0").asText());
    }
}
