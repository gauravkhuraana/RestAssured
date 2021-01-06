package gsonAPI;
import com.google.gson.Gson;
import jacksonAPI.udzial_employees_Serlialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class deserialisation_Via_Gson {

    public static void main(String[] args) throws FileNotFoundException {
        String jsonStr = "{\n" +
                "  \"firstName\": \"Sammy\",\n" +
                "  \"lastName\": \"Khurana\",\n" +
                "  \"gender\": \"M\",\n" +
                "  \"age\": 27,\n" +
                "  \"salary\": 250000.0,\n" +
                "  \"married\": true\n" +
                "}";

        // From JSON to javaObjects - Deserialization

        Gson gs = new Gson();
        udzial_employees_Serlialization obj = gs.fromJson(jsonStr, udzial_employees_Serlialization.class);

        String firstName = obj.getFirstName();
        String secondName = obj.getLastName();
        int age = obj.getAge();
        boolean married = obj.isMarried();
        char gender = obj.getGender();
        double salary = obj.getSalary();

        System.out.println("First Name " + firstName);
        System.out.println("Second Name " + secondName);
        System.out.println("Age " + age);
        System.out.println("Salary " + salary);
        System.out.println("Married " + married);
        System.out.println("Gender " + gender );


        System.out.println(" **** Json to Java object **** ");

        // De-Serialization from an external file

        String userDir = System.getProperty("user.dir");
        File jsonFile  = new File(userDir + "\\src\\main\\resources\\gsonCreatedJson");

        FileReader fr = new FileReader(jsonFile);
        udzial_employees_Serlialization obj1 = gs.fromJson(fr,udzial_employees_Serlialization.class);

         firstName = obj1.getFirstName();
         secondName = obj1.getLastName();
         age = obj1.getAge();
         married = obj1.isMarried();
         gender = obj1.getGender();
         salary = obj1.getSalary();

        System.out.println("First Name " + firstName);
        System.out.println("Second Name " + secondName);
        System.out.println("Age " + age);
        System.out.println("Salary " + salary);
        System.out.println("Married " + married);
        System.out.println("Gender " + gender );




    }

}
