package jacksonAPI.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class getAllKeysFromJson {


    @Test
    public void getAllKeysInMap() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "\"Name\":\"Krishna\",\n" +
                "\"Surname\":\"Hari\",\n" +
                "\"Place\":\"Vrindavan\"\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();
        Map<String,String> mapJson = objMap.readValue(jsonStr, new TypeReference<Map<String, String>>() {
        });

        //Get all keys
        Set<String> allKeys = mapJson.keySet();
        System.out.println(" All Keys are");
        allKeys.stream().forEach(k->System.out.println(k));



    }

    @Test
    public void getAllKeyUsingJsonNode() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "\"Name\":\"Krishna\",\n" +
                "\"Surname\":\"Hari\",\n" +
                "\"Place\":\"Vrindavan\"\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();
        JsonNode jsN = objMap.readTree(jsonStr);

        Iterator<String> allKeys = jsN.fieldNames();
        System.out.println("All Keys are ");
        allKeys.forEachRemaining(k->System.out.println(k));


    }

    @Test
    public void getAllKeysFromNestedJsonUsingMap() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "\t\"Name\": \"Krishna\",\n" +
                "\t\"Surname\": \"Hari\",\n" +
                "\t\"Place\": \"Vrindavan\",\n" +
                "\n" +
                "\t\"friends\": {\n" +
                "\t\t\"name\": \"Sudama\",\n" +
                "\t\t\"place\": \"sudamapuri\"\n" +
                "\t}\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();
        Map<String,Object> mpJson = objMap.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
                    });

        Set<String> allKeys = mpJson.keySet();

        // Iterate Keys
        allKeys.stream().forEach(key -> {
            Object value = mpJson.get(key);
            if( value instanceof String)
            {
                System.out.println(key);
            }
            else if (value instanceof LinkedHashMap<?,?>)
            {
                Set<String> keysOfNested = ((LinkedHashMap<String,?>)value).keySet();
                keysOfNested.stream().forEach(k->System.out.println(k));
            }
        });
    }

    @Test
    public void getAllKeysJsonNode() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "\t\"Name\": \"Krishna\",\n" +
                "\t\"Surname\": \"Hari\",\n" +
                "\t\"Place\": \"Vrindavan\",\n" +
                "\n" +
                "\t\"friends\": {\n" +
                "\t\t\"name\": \"Sudama\",\n" +
                "\t\t\"place\": \"sudamapuri\"\n" +
                "\t}\n" +
                "}\n";

        ObjectMapper objMap = new ObjectMapper();
        JsonNode jsNod = objMap.readTree(jsonStr);
        Iterator<String> allKeys = jsNod.fieldNames();
        allKeys.forEachRemaining(k-> {
                    Object value = jsNod.get(k);
                    if( value instanceof TextNode)
                    {
                        System.out.println(k);
                    }
                    else if(value instanceof ObjectNode)
                    {
                        Iterator<String> nestKey = ((ObjectNode)value).fieldNames();
                        nestKey.forEachRemaining(ke->System.out.println(ke));

                    }

                }
                );

    }


}
