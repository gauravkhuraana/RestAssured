package jacksonAPI.annotations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class employee_non_null_values {

    // Based on this sequence json will be created
    private int age;
    private String firstName;
    private String secondName;
    private String gender;
    private double salary;

    //can be applied at individual element level as well
    //@JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean married;

    public String getFirstName() {

        System.out.println("Inside First");
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {

        System.out.println("Inside second");
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

   /* public String getGender() {
        System.out.println("Inside gender");
        return gender;
    }*/

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
        this.salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public static void main(String[] args) throws JsonProcessingException {
        employee_non_null_values obj = new employee_non_null_values();
     //   obj.setAge(20);
     //  obj.setFirstName("Gaurav");
       //Gender will not come since default value of String is null
         obj.setGender("Male");
       // obj.setMarried(true);
       // obj.setSecondName("Khurana");
        // Salary is not set but still coming in output so default value will be picked


      //Default values will come if we have included non_null, so salary will come
        //  obj.setSalary(0.0);


        // Serialization
        System.out.println("Serialization will use getter methods");
        ObjectMapper objMap = new ObjectMapper();
        String json = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(json);


    }
}
