package json;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;

public class jsonPathExtractionWithFilters {

    @Test
    public void jsonPathFilters()
    {
        File jsonArrayFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\jsonArraySyntaxDemo.json");
        JsonPath jsP = JsonPath.from(jsonArrayFile);

        String firstFirstName = jsP.getString("[0].first_name");
        System.out.println("firstName of first employee " + firstFirstName);

        String firstEmployeeDetails = jsP.getString("[0]");
        System.out.println("First employee all details " + firstEmployeeDetails);

        String firstNameOfAllEmployees = jsP.getString("first_name");
        System.out.println("firstName of all employee " + firstNameOfAllEmployees);

        String allFemaleEmployees = jsP.getString("findAll{it.gender=='Female'}.first_name");
        System.out.println("firstName of all female employee " + allFemaleEmployees);

        // Other same syntax
        allFemaleEmployees = jsP.getString("findAll{it->it.gender=='Female'}.first_name");
        System.out.println("firstName of all female employee with similar syntax " + allFemaleEmployees);

        // Integer filter
        String empWithSomeId = jsP.getString("findAll{it.id>=5}.first_name");
        System.out.println("Employees whose id is equal or more than 5"+empWithSomeId);

        // Integer filter with relational operator
        String empWithSomeIdLessThan = jsP.getString("findAll{it.id>=5 & it.id<8}.first_name");
        System.out.println("Employees whose id is equal or more than 5 but less than 8 "+empWithSomeIdLessThan);

        // Relational operator with integer and String filters
        String idAndGenderLogic = jsP.getString("findAll{it.id>=5 & it.gender=='Female'}.first_name");
        System.out.println("Employees whose id is equal or more than 5 and gender is female "+idAndGenderLogic);

        // Size of the array
        String size = jsP.getString("size()");
        System.out.println("Size of the array is "+size);


    }
}
