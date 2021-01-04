package Pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class convertClassObj_to_Json_Seralization_Deserialisation {

    @Test
    public void convertobjToJson() throws JsonProcessingException {
        underStandingPojo employee = new underStandingPojo();

        employee.setCityName("Delhi");
        employee.setFirstname("Gaurav");
        employee.setLastname("Khurana");
        employee.setFullName("Gaurav khurana full");
        employee.setGender('M');

        ObjectMapper obj = new ObjectMapper();

        String employeeJson = obj.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(employeeJson);
    }

    // Deserialisation
    @Test
    public void readFromJsonObject() throws JsonProcessingException {
        underStandingPojo obj = new underStandingPojo();
        obj.setGender('F');
        obj.setFullName("Samriddhi");
        obj.setLastname("Arora");
        obj.setSalary(59999900);
        obj.setCityName("Rajasathan");

        ObjectMapper objMap = new ObjectMapper();
        String JsonValue= objMap.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

        // Doing the deserialisation
        underStandingPojo employee = objMap.readValue(JsonValue,underStandingPojo.class);

        System.out.println(" First Name "+ employee.getFirstname());
        System.out.println(" Last Name "+ employee.getLastname());
        System.out.println(" City Name  "+ employee.getCityName());
        System.out.println(" Full Name "+ employee.getFullName());
        System.out.println(" Salary "+ employee.getSalary());





    }
}
