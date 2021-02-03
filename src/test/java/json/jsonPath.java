package json;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class jsonPath {


    @Test
    public void getFullJson()
    {

        String jsonStr = "{\"username\":\"admin\",\n" +
                "\"password\":\"password123\"}";

        JsonPath jsP = JsonPath.from(jsonStr);

        String fName = jsP.getString("username");
        String sName = jsP.getString("password");

        // Full Json
        System.out.println(jsP.getString("$"));
        // Other 2 ways
        System.out.println(jsP.getString(""));

        // Below one not working
        //System.out.println(jsP.get());


    }
    @Test
    public void nestedJsonObject()
    {
        String jsonString = "{\r\n" +
                "  \"firstName\": \"Gaurav\",\r\n" +
                "  \"lastName\": \"Krishna\",\r\n" +
                "  \"address\": {\r\n" +
                "    \"houseNo\": 404,\r\n" +
                "    \"buildingName\": \"Not Found\",\r\n" +
                "    \"streetName\": \"Gumnam gali\",\r\n" +
                "    \"city\": \"Bengaluru\",\r\n" +
                "    \"state\": \"Karnataka\",\r\n" +
                "    \"country\": \"India\"\r\n" +
                "  },\r\n" +
                "  \"skills\": {\r\n" +
                "    \"language\": {\r\n" +
                "      \"name\": \"Java\",\r\n" +
                "      \"proficiency\": \"Medium\"\r\n" +
                "    }\r\n" +
                "  }\r\n" +
                "}";

        JsonPath jsP  = JsonPath.from(jsonString);

        int houseN = jsP.getInt("address.houseNo");
        System.out.println(" House number "+ houseN);

        String name = jsP.getString("skills.language.name");
        System.out.println(" Name which is 2 level inside ");

    }

    @Test
    public void jsonArray()
    {

        String jsonArrayString = "{\r\n" +
                "  \"firstName\": \"Amod\",\r\n" +
                "  \"lastName\": \"Mahajan\",\r\n" +
                "  \"address\": [\r\n" +
                "    {\r\n" +
                "      \"type\": \"permanent\",\r\n" +
                "      \"city\": \"Bengaluru\",\r\n" +
                "      \"state\": \"KA\"\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"type\": \"temp\",\r\n" +
                "      \"city\": \"Bhopal\",\r\n" +
                "      \"state\": \"MP\"\r\n" +
                "    }\r\n" +
                "  ]\r\n" +
                "}";

        JsonPath jsP = JsonPath.from(jsonArrayString);

        String addressType1 = jsP.getString("address[0].type");
        System.out.println("Address Type 1 is " + addressType1);

        String addressType2 = jsP.getString("address[1].type");
        System.out.println("Address Type 2 is "+ addressType2);

        // Get all types at once
        List<String> allAddressTypes = jsP.getList("address.type");
        System.out.println(allAddressTypes);

        // Get the complete Json Object from within a json

        List<Map<String,Object>> allAddress = jsP.getList("address");

        for(Map<String,Object> address : allAddress)
        {
            System.out.println(address);
        }



    }

    @Test
    public void nestedJsonArray()
    {
        String jsonArrayString = "{\r\n" +
                "  \"firstName\": \"Amod\",\r\n" +
                "  \"lastName\": \"Mahajan\",\r\n" +
                "  \"address\": [\r\n" +
                "    [\r\n" +
                "      {\r\n" +
                "        \"type\": \"permanent\",\r\n" +
                "        \"city\": \"Bengaluru\",\r\n" +
                "        \"state\": \"KA\"\r\n" +
                "      },\r\n" +
                "      {\r\n" +
                "        \"type\": \"temp\",\r\n" +
                "        \"city\": \"Bhopal\",\r\n" +
                "        \"state\": \"MP\"\r\n" +
                "      }\r\n" +
                "    ],\r\n" +
                "    [\r\n" +
                "      {\r\n" +
                "        \"type\": \"communication\",\r\n" +
                "        \"city\": \"Delhi\",\r\n" +
                "        \"state\": \"DL\"\r\n" +
                "      },\r\n" +
                "      {\r\n" +
                "        \"type\": \"old\",\r\n"+
                "        \"city\": \"Kanpur\",\r\n" +
                "        \"state\": \"UP\"\r\n" +
                "      }\r\n" +
                "    ]\r\n" +
                "  ]\r\n" +
                "}";

        JsonPath jsP = JsonPath.from(jsonArrayString);

        String fullJson = jsP.getString("$");
        System.out.println(fullJson);

        String addressType1 = jsP.getString("address[0][0].type");
        System.out.println(addressType1);
        String addressType2 = jsP.getString("address[0][1].type");
        System.out.println(addressType2);

        String addressType3 = jsP.getString("address[1][0].type");
        System.out.println(addressType3);
        String addressType4 = jsP.getString("address[1][1].type");
        System.out.println(addressType4);


        // Get address Types from first array of address
        List<String> allAdrressTypeFromFirstArray = jsP.get("address[0].type");
        System.out.println(allAdrressTypeFromFirstArray);

        // Get city  from second array
        List<String> allcityFromSecond = jsP.get("address[1].city");
        System.out.println(allcityFromSecond);

        //to get address type from all the nested elements
        List<String> allAddressType = jsP.getList("address.type");
        System.out.println(allAddressType);

    }
}
