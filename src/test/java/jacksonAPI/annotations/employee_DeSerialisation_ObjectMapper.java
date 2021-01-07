package jacksonAPI.annotations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class employee_DeSerialisation_ObjectMapper {

    // Based on this sequence json will be created
    private int age;
    private String firstName;
    private String secondName;
    private String gender;
    private double salary;


    private boolean married;

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {

        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGender() {
        System.out.println("Inside gender");
        return gender;
    }

    public void setGender(String gender) {


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

    public void setSalary(double salary) {

        System.out.println(" I am salary setter method. I will be called");
        this.salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public static void main(String[] args) throws JsonProcessingException {



        String jsonStr = "{\n" +
                "  \"age\" : 0,\n" +
                "  \"Name\" : \"Gaurav\",\n" +
                "  \"secondName\" : \"Khurana\",\n" +
                "  \"salary\" : 0.0,\n" +
                "  \"married\" : false\n" +
                "}";


        // DeSerialization
        System.out.println("DeSerialization will use Setter methods");
        ObjectMapper objMap = new ObjectMapper();

       // We have used objectMapper configuration to ignore the unknonw properties
        objMap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        employee_DeSerialisation_ObjectMapper obj = objMap.readValue(jsonStr, employee_DeSerialisation_ObjectMapper.class);

        System.out.println(obj.getAge());

        // Default value
        System.out.println("Firstname =" + obj.getFirstName());

        System.out.println(obj.getGender());
        System.out.println(obj.getSecondName());




    }
}
