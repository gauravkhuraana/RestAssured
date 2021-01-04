package Pojo;

import java.util.List;

public class nestedJsonArray_jsonObject {

    private String companyName;
    private String companyHOCity;
    private String companyCEO;

    private List<String> supportedSal;
    private List<Integer> pincodesOfCityOffice;



    public List<EmployeeClass> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeClass> employee) {
        this.employee = employee;
    }

    public List<Pojo.contractors> getContractors() {
        return contractors;
    }

    public void setContractors(List<Pojo.contractors> contractors) {
        this.contractors = contractors;
    }

    List<EmployeeClass> employee;
    List<contractors> contractors;
    companyPFDetails companyPF;

    // Getter setter even for objects

        public companyPFDetails getCompanyPF() {
        return companyPF;
    }

    public void setCompanyPF(companyPFDetails companyPF) {
        this.companyPF = companyPF;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyHOCity() {
        return companyHOCity;
    }

    public void setCompanyHOCity(String companyHOCity) {
        this.companyHOCity = companyHOCity;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public List<String> getSupportedSalary2() {
        return supportedSal;
    }

    public void setSupportedSal(List<String> supportedSalary2) {
        this.supportedSal = supportedSalary2;
    }

    public List<Integer> getPincodesOfCityOffice() {
        return pincodesOfCityOffice;
    }

    public void setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
        this.pincodesOfCityOffice = pincodesOfCityOffice;
    }


}
