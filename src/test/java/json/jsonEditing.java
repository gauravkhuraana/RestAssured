package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

public class jsonEditing {

    String strJson = " {\n" +
            "            \"firstname\": \"Jim\",\n" +
            "            \"lastname\": \"Brown\"}";

    @Test
    public void addToJson() throws JsonProcessingException {

        ObjectMapper objMap = new ObjectMapper();

        ObjectNode objN = objMap.readValue(strJson,ObjectNode.class);
        objN.put("role","admininis");
        System.out.println(objN.toPrettyString());

    }

    @Test
    public void addJsonObject() throws JsonProcessingException {
        ObjectMapper objMap = new ObjectMapper();
        ObjectNode objN = objMap.readValue(strJson,ObjectNode.class);

        ObjectNode bookingDetails = objMap.createObjectNode();
        bookingDetails.put("firstname","Hare");
        bookingDetails.put("lastname","Krishna");
        objN.set("bookingDetails",bookingDetails);

        System.out.println(objN.toPrettyString());
    }

    @Test
    public void addNewKeyToNestedJson() throws JsonProcessingException {
        String jsonStr="{\n" +
                "  \"firstname\" : \"Jim\",\n" +
                "  \"lastname\" : \"Brown\",\n" +
                "  \"bookingDetails\" : {\n" +
                "    \"firstname\" : \"Hare\",\n" +
                "    \"lastname\" : \"Krishna\"\n" +
                "  }\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();

        ObjectNode objN = objMap.readValue(jsonStr,ObjectNode.class);

        objN.with("bookingDetails").put("gender","male");
        System.out.println(objN.toPrettyString());

    }

    @Test
    public void updateExistingValues() throws JsonProcessingException {
        String jsonStr="{\n" +
                "  \"firstname\" : \"Jim\",\n" +
                "  \"lastname\" : \"Brown\",\n" +
                "  \"bookingDetails\" : {\n" +
                "    \"firstname\" : \"Hare\",\n" +
                "    \"lastname\" : \"Krishna\"\n" +
                "  }\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();
        ObjectNode objN = objMap.readValue(jsonStr,ObjectNode.class);
        objN.with("bookingDetails").put("gender","male");
        objN.with("bookingDetails").put("gender","female");

        objN.put("firstname","Haribol");

        System.out.println(objN.toPrettyString());

    }

    @Test
    public void removeKeys() throws JsonProcessingException {
        String jsonStr="{\n" +
                "  \"firstname\" : \"Jim\",\n" +
                "  \"lastname\" : \"Brown\",\n" +
                "  \"bookingDetails\" : {\n" +
                "    \"firstname\" : \"Hare\",\n" +
                "    \"lastname\" : \"Krishna\"\n" +
                "  }\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();
        ObjectNode objN = objMap.readValue(jsonStr,ObjectNode.class);

        objN.remove("bookingDetails");
        objN.remove("lastname");

        System.out.println(objN.toPrettyString());
    }
}
