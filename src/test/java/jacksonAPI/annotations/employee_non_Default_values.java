package jacksonAPI.annotations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class employee_non_Default_values {

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
        this.salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public static void main(String[] args) throws JsonProcessingException {
        employee_non_Default_values obj = new employee_non_Default_values();
        obj.setAge(20);
        obj.setFirstName("Gaurav");
       // obj.setGender("Male");
        obj.setMarried(true);
        obj.setSecondName("Khurana");
        // Salary is not set but still coming in output so default value will be picked

        // Interview question
        //if you try to set the default values those will not come
        // as it filters those values, so here salary wont be appear in output
        obj.setSalary(0.0);


        // Serialization
        ObjectMapper objMap = new ObjectMapper();
        String json = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(json);


    }
}
