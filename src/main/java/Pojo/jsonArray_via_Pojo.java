package Pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class jsonArray_via_Pojo {

    String jsonArray;
    @Test
    public void jsonArray_viaPojo() throws JsonProcessingException {
        underStandingPojo Krishna = new underStandingPojo();
        underStandingPojo balaram = new underStandingPojo();
        underStandingPojo radhaji = new underStandingPojo();

        Krishna.setCityName("Mathura");
        Krishna.setFirstname("Govinda");
        Krishna.setFullName("Krishna Kanhaiya");
        Krishna.setGender('M');
        Krishna.setMarried(true);
        Krishna.setLastname("Vaasudev");
        Krishna.setSalary(1000000000);

        balaram.setSalary(250000000);
        balaram.setLastname("nityanand prabhu");
        balaram.setMarried(true);
        balaram.setGender('M');
        balaram.setFullName("Laxman Balaram");
        balaram.setFirstname("Laxman ji");
        balaram.setCityName("Vrindavan");


        radhaji.setSalary(550000000);
        radhaji.setLastname("Radharaani");
        radhaji.setMarried(false);
        radhaji.setGender('F');
        radhaji.setFullName("Shrimati RadhaRaani");
        radhaji.setFirstname("Radha ji");
        radhaji.setCityName("Barsana");

        // Important Step

        List<underStandingPojo> li = new ArrayList<underStandingPojo>();
        li.add(Krishna);
        li.add(balaram);
        li.add(radhaji);

        ObjectMapper obj = new ObjectMapper() ;

         jsonArray =obj.writerWithDefaultPrettyPrinter().writeValueAsString(li);
        System.out.println(jsonArray);


    }

    @Test
    public void printAJsonArray_viaPojo() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        List<underStandingPojo> jsnArray=obj.readValue(jsonArray, new TypeReference<List<underStandingPojo>>() {
        });

        for(underStandingPojo pj:jsnArray)
        {
            System.out.println("\n Printing the json object ");
            System.out.println(pj.getFirstname());
            System.out.println(pj.getLastname());
            System.out.println(pj.getFullName());
            System.out.println(pj.getGender());
            System.out.println(pj.isMarried());
            System.out.println(pj.getSalary());

        }


    }


}
