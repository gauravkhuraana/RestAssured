package gsonAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jacksonAPI.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class serialisation_Via_Gson {

    public static void main(String[] args) throws IOException {

        udzial_employees_Serlialization  emp = new udzial_employees_Serlialization();
        emp.setAge(29);
        emp.setFirstName("Himanshu");
        emp.setGender('M');
        emp.setLastName("Khurana");
        emp.setSalary(250000);

        Gson gs = new Gson();

        // non Pretty version
        String jsonStr= gs.toJson(emp);
        System.out.println("NOt a pretty json String");
        System.out.println(jsonStr);

        // Pretty version
        Gson gsb = new GsonBuilder().setPrettyPrinting().create();
        String jsonPrettyStr = gsb.toJson(emp);
        System.out.println("Preety json String");
        System.out.println(jsonPrettyStr);

         // to Write to external file
        //
        String userDir = System.getProperty("user.dir");

        File outJsonFile = new File(userDir+ "\\src\\main\\resources\\gsonCreatedJson");
        FileWriter fw = new FileWriter(outJsonFile);
        // this accepts fileWriter and not just file object
        gsb.toJson(emp,fw);

        // if not called file will be empty
        fw.flush();

    }
}
