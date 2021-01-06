package jacksonAPI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(value = {"salary","gender"},allowGetters = true)
public class employee_Serialisation_GetterMethods {

    // Based on this sequence json will be created
    private int age;
    private String firstName;
    private String secondName;
    private String gender;
    private double salary;

    @JsonIgnore
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

    // Age will not be used for serialisation or deserialisation
    @JsonIgnore
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

      employee_Serialisation_GetterMethods obj = new employee_Serialisation_GetterMethods();
      obj.setSalary(18000);
      obj.setAge(23);
      //obj.setFirstName("Gaurav");
      obj.setSecondName("Arora");

        // Serialization

        System.out.println("Serialization will use Getter methods , if atleast one is there it will work");
        ObjectMapper objMap = new ObjectMapper();
        String jsonStr = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(jsonStr);



    }
}
