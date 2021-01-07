package jacksonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class udzial_employees_Deserialisation {

    public static void main(String[] args) throws JsonProcessingException {
        String jsonStr = "{\n" +
                "  \"firstName\" : \"Gaurav\",\n" +
                "  \"lastName\" : \"Khurana\",\n" +
                "  \"gender\" : \"M\",\n" +
                "  \"age\" : 30,\n" +
                "  \"salary\" : 25000.0,\n" +
                "  \"married\" : true\n" +
                "}";

        ObjectMapper objMap = new ObjectMapper();

        udzial_employees_Serlialization emp = objMap.readValue(jsonStr, udzial_employees_Serlialization.class);

        System.out.println("First Name is " + emp.getFirstName());
        System.out.println("Last Name is " + emp.getLastName());
       // System.out.println("Age is " + emp.getAge());
        System.out.println("Gender is " + emp.getGender());
      //  System.out.println("Salary is " + emp.getSalary());
        System.out.println("First Name is " + emp.isMarried());

    }

    }
