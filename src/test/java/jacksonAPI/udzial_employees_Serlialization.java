package jacksonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class udzial_employees_Serlialization {

    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private double salary;
    private boolean married;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

   public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }


    public static void main(String [] args) throws IOException {
        udzial_employees_Serlialization emp_pojo =new udzial_employees_Serlialization();

        emp_pojo.setAge(30);
        emp_pojo.setFirstName("Gaurav");
        emp_pojo.setLastName("Khurana");
        emp_pojo.setGender('M');
        emp_pojo.setMarried(true);
        emp_pojo.setSalary(25000);

        ObjectMapper obj = new ObjectMapper();

        // Serialization Example
        // Converting a java object to json

        String convertedJson = obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp_pojo);
        System.out.println(convertedJson);

        // put the json file which is serialised in a file

        String userDir = System.getProperty("user.dir");
        File outputJson = new File(userDir+"\\src\\main\\resources\\Employee.json");
        obj.writerWithDefaultPrettyPrinter().writeValue(outputJson,emp_pojo);




    }


}
