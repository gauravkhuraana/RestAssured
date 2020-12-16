package RestfulBooker.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import sun.rmi.transport.ObjectTable;

import java.util.*;
import java.util.Map.Entry;

public class postRequest_jsonObject_jacksonAPI_objectMapper {


    @Test
    public void javaSet_JsonObjects() throws JsonProcessingException {


        ObjectMapper objMap = new ObjectMapper();

        ObjectNode bookingDetails = objMap.createObjectNode();

        bookingDetails.put("firstname", "Hare");
        bookingDetails.put("additionalneeds", "Dinner");
        bookingDetails.put("totalprice", 25634);
        bookingDetails.put("depositpaid", true);
        bookingDetails.put("lastname", "Krishna");
        bookingDetails.put("lastname", "Hare");

        String simpleJsonObj = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("simple Json" + simpleJsonObj);

        ObjectNode inside_objNode = objMap.createObjectNode();

        inside_objNode.put("checkin", "2021-09-01");
        inside_objNode.put("checkout", "2021-09-05");

        // for nested json only set to be used , put is depreciated
        bookingDetails.set("bookingdates", inside_objNode);

        String complexJsonObj = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("Complex json " + complexJsonObj);
      getFieldsFromJson(bookingDetails);
      removeNode(bookingDetails,objMap);

    }



    public static void getFieldsFromJson(ObjectNode objJsonNode) {

        String firstName = objJsonNode.get("firstname").asText();
        System.out.println("First Name = "+ firstName);

        boolean depositPaid = objJsonNode.get("depositpaid").asBoolean();
        System.out.println("Value of DepositPaid = "+ depositPaid);

        Integer totalprice = objJsonNode.get("totalprice").asInt();
        System.out.println("Value of amount "+totalprice);

        // for complex element you have to call get function twice
        String nestedJsonElement = objJsonNode.get("bookingdates").get("checkin").asText();
        System.out.println("Value of check in is "+ nestedJsonElement);

        getAllFieldsValue(objJsonNode);

    }


    public static void getAllFieldsValue(ObjectNode jsonNodes)
    {
        Iterator<String> itr_keys = jsonNodes.fieldNames();
        System.out.println("Fields are Keys :- ");
        while(itr_keys.hasNext())
        {
            System.out.println(itr_keys.next());
        }

        Iterator<JsonNode> itr_value = jsonNodes.elements();
        System.out.println(" Json Elements are values :- ");
        while(itr_value.hasNext())
        {
            System.out.println(itr_value.next());
        }
        getAllFields_and_theirValues(jsonNodes);

    }

    public static void getAllFields_and_theirValues(ObjectNode jsonNod)
    {
        Iterator<Entry<String,JsonNode>> fullIterator = jsonNod.fields();
        System.out.println("Printing all FieldNames(keys) and their values(elements)");
        while(fullIterator.hasNext())
        {
           Entry<String,JsonNode> pair=fullIterator.next();
           System.out.println(" Key = "+pair.getKey() + " Value = "+pair.getValue());
        }

    }

    public static void removeNode (ObjectNode on, ObjectMapper mainJson) throws JsonProcessingException {
        String removeFieldValue = on.remove("firstname").asText();
        System.out.println("Firstname removed value is "+ removeFieldValue);

        String modifiedJson = mainJson.writerWithDefaultPrettyPrinter().writeValueAsString(on);
        System.out.println("Modified json "+ modifiedJson );

        String booking = on.remove("bookingdates").asText();
        System.out.println(booking);

        modifiedJson=mainJson.writerWithDefaultPrettyPrinter().writeValueAsString(on);
        System.out.println("After deleting dates "+modifiedJson);



    }




    }




