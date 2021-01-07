package Pojo;

public class underStandingPojo {

        // Private Data Members
        private String firstname;
        private String lastname;
        private double salary;
        private String cityName;
        private boolean isMarried;
        private char gender;
        private String fullName;

    // Default Constructor
    public underStandingPojo() {
    }

    // Methods for doing calculations over
    public String getFullName() {
         this.fullName = this.firstname + " " + this.lastname;
         return fullName;
         }


        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public boolean isMarried() {
            return isMarried;
        }

        public void setMarried(boolean married) {
            isMarried = married;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }



    }




