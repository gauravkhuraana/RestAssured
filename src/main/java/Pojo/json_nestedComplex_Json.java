package Pojo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class json_nestedComplex_Json {

    public static void main(String[] args) throws JsonProcessingException {
        nestedJsonArray_jsonObject nestedPojo = new nestedJsonArray_jsonObject();

        nestedPojo.setCompanyName("Udzial");
        nestedPojo.setCompanyHOCity("Delhi");
        nestedPojo.setCompanyCEO("Krishna");

        List<String> supportedSalaryBanks1 = new ArrayList<String>();
        supportedSalaryBanks1.add("PNB");
        supportedSalaryBanks1.add("ICICI");
        supportedSalaryBanks1.add("IDBI");

        nestedPojo.setSupportedSal(supportedSalaryBanks1);

        List<Integer> pincodes = new ArrayList<Integer>();
        pincodes.add(560037);
        pincodes.add(360045);
        pincodes.add(110045);
        nestedPojo.setPincodesOfCityOffice(pincodes);

        // Create first Employee
        EmployeeClass emp = new EmployeeClass();

        emp.setAge(30);
        emp.setFirstname("Hare");
        emp.setLastname("Krishna");
        emp.setGender("Male");
        emp.setMarried(true);

        // Create first Employee
        EmployeeClass empSecond = new EmployeeClass();

        empSecond.setAge(25);
        empSecond.setFirstname("Hari");
        empSecond.setLastname("Bol");
        empSecond.setGender("FeMale");
        empSecond.setMarried(false);


        // Create first Employee
        EmployeeClass empThird = new EmployeeClass();

        empThird.setAge(28);
        empThird.setGender("Female");
        empThird.setMarried(false);
        empThird.setFirstname("Radha");
        empThird.setLastname("Hari");


        List<EmployeeClass> list = new ArrayList<EmployeeClass>();

        //list.add(emp);
        //list.add(empSecond);
        //list.add(empThird);

        list.addAll(Arrays.asList(empSecond,empThird,emp));

        nestedPojo.setEmployee(list);

        List<contractors> liCon = new ArrayList<contractors>();

        contractors con1 = new contractors();
        con1.setContractFrom("Jan 2018");
        con1.setContractTo("Mar 2020");
        con1.setFirstName("Udzial");
        con1.setLastName("Share");

        contractors con2 = new contractors();
        con2.setContractFrom("Jan 2019");
        con2.setContractTo("Mar 2021");
        con2.setFirstName("Share");
        con2.setLastName("Means");
        liCon.addAll(Arrays.asList(con1,con2));

        nestedPojo.setContractors(liCon);

        companyPFDetails companyPF = new companyPFDetails();
        companyPF.setNoOfEmployees(1000);
        companyPF.setPfCity("Hyd");
        companyPF.setPfName("Hari Bol");
        companyPF.setPfYear(2021);

        nestedPojo.setCompanyPF(companyPF);

        ObjectMapper objMap = new ObjectMapper();
        String fullJson = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(nestedPojo);
        System.out.println(fullJson);













    }
}
