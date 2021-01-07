package jacksonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;
import java.util.Iterator;

public class jsonArrayRequestBody {

    public static void main(String[] ar) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();

        ArrayNode parentArray = obj.createArrayNode();

        // First node
        ObjectNode objNodFirst = obj.createObjectNode();

        // First Element
        objNodFirst.put("firstname","Hare");
        objNodFirst.put("lasname","Krishna");
        objNodFirst.put("totalprice",111);
        objNodFirst.put("depositpaid",true);
        objNodFirst.put("additionalNeeds","Dinner");
        // Nested of First
        ObjectNode objFirstNested = obj.createObjectNode();
        objFirstNested.put("checkin","2021-08-01");
        objFirstNested.put("checkout","2021-08-03");

        objNodFirst.set("bookingdates",objFirstNested);

        // Second node
        ObjectNode objNodSecond = obj.createObjectNode();

        // second node elements
        objNodSecond.put("firstname","HAri");
        objNodSecond.put("lasname","Ram");
        objNodSecond.put("totalprice",111);
        objNodSecond.put("depositpaid",true);
        objNodSecond.put("additionalNeeds","Dinner");
        // Nested of Second
        ObjectNode objSecondNested = obj.createObjectNode();
        objSecondNested.put("checkin","2021-08-01");
        objSecondNested.put("checkout","2021-08-03");

        objNodSecond.set("bookingdates",objSecondNested);

        // Add to parent
       // parentArray.add(objNodFirst);
       // parentArray.add(objNodSecond);
        //or
        parentArray.addAll(Arrays.asList(objNodFirst,objNodSecond));

        // print the jsonArray
        String jsonArrayAsString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray);
        System.out.println("Created Json Array is : ");
        System.out.println(jsonArrayAsString);

        // to get the first JsonObject
        JsonNode element = parentArray.get(0);
        System.out.println("Get the First Element");
        System.out.println(obj.writerWithDefaultPrettyPrinter().writeValueAsString(element));

        // To get the size of all the elements
        int sizeOfJsonArray = parentArray.size();
        System.out.println("Size of the jsonArray is "+ sizeOfJsonArray);

        // To iterate the JSON Array
        Iterator<JsonNode> it = parentArray.iterator();
        System.out.println("Print using Json Node Using Iterator");

        while(it.hasNext())
        {
            JsonNode node = it.next();
            System.out.println(obj.writerWithDefaultPrettyPrinter().writeValueAsString(node));
        }

        System.out.println(" Removing the First Element");
        parentArray.remove(0);
        System.out.println(obj.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));

        System.out.println(" Removing all the Elements");
        parentArray.removeAll();
        System.out.println(obj.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));







    }
}
