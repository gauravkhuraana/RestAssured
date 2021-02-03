package json;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class jsonDeserialisationJsonPath {

    public static class Employee {

        private Integer id;
        private String first_name;
        private String last_name;
        private String email;
        private String gender;

        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getFirst_name() {
            return first_name;
        }
        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }
        public String getLast_name() {
            return last_name;
        }
        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getGender() {
            return gender;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    @Test
    public void deserialize()
    {
        String jsonObject = "{\r\n" +
                "  \"id\": 1,\r\n" +
                "  \"first_name\": \"Lothaire\",\r\n" +
                "  \"last_name\": \"Benazet\",\r\n" +
                "  \"email\": \"lbenazet0@tinyurl.com\",\r\n" +
                "  \"gender\": \"Male\"\r\n" +
                "}";

        JsonPath jsP = JsonPath.from(jsonObject);

        Employee emp = jsP.getObject("",Employee.class);

        System.out.println(emp.getId());
        System.out.println(emp.getFirst_name());
        System.out.println(emp.getLast_name());
        System.out.println(emp.getEmail());
        System.out.println(emp.getGender());

        // Another way
        emp = jsP.getObject("$",Employee.class);

        System.out.println(emp.getId());
        System.out.println(emp.getFirst_name());
        System.out.println(emp.getLast_name());
        System.out.println(emp.getEmail());
        System.out.println(emp.getGender());


    }

    @Test
    public void deserialiseAParticularOject()
    {
        String jsonObject = "[{\r\n" +
                "  \"id\": 1,\r\n" +
                "  \"first_name\": \"Lothaire\",\r\n" +
                "  \"last_name\": \"Benazet\",\r\n" +
                "  \"email\": \"lbenazet0@tinyurl.com\",\r\n" +
                "  \"gender\": \"Male\"\r\n" +
                "}, {\r\n" +
                "  \"id\": 2,\r\n" +
                "  \"first_name\": \"Shellie\",\r\n" +
                "  \"last_name\": \"Cowser\",\r\n" +
                "  \"email\": \"scowser1@163.com\",\r\n" +
                "  \"gender\": \"Female\"\r\n" +
                "}]";

        JsonPath jsP = JsonPath.from(jsonObject);

        Employee emp = jsP.getObject("[0]", Employee.class);
        System.out.println(emp.getLast_name());
        System.out.println(emp.getFirst_name());
        System.out.println(emp.getId());
        System.out.println(emp.getEmail());
        System.out.println(emp.getGender());

    }


}
