package Pojo;

public class companyPFDetails {

    private String pfName;
    private String pfCity;
    private Integer pfYear;
    private Integer noOfEmployees;

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPfCity() {
        return pfCity;
    }

    public void setPfCity(String pfCity) {
        this.pfCity = pfCity;
    }

    public Integer getPfYear() {
        return pfYear;
    }

    public Integer setPfYear(Integer pfYear) {
        return pfYear;
    }

    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    public Integer setNoOfEmployees(Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
        return noOfEmployees;
    }
}
