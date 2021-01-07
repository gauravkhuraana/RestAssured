package Pojo;

public class implementing_Pojo {

    public static void main(String[] args)
    {

        underStandingPojo Krishna = new underStandingPojo();
        underStandingPojo balaram = new underStandingPojo();

        Krishna.setCityName("Mathura");
        Krishna.setFirstname("Govinda");
        Krishna.setFullName("Krishna Kanhaiya");
        Krishna.setGender('M');
        Krishna.setMarried(true);
        Krishna.setLastname("Vaasudev");
        Krishna.setSalary(1000000000);

        balaram.setSalary(250000000);
        balaram.setLastname("nityanand prabhu");
        balaram.setMarried(true);
        balaram.setGender('M');
        balaram.setFullName("Laxman Balaram");
        balaram.setFirstname("Laxman ji");
        balaram.setCityName("Vrindavan");


        System.out.println(Krishna.getFirstname());
        System.out.println(Krishna.getLastname());
        System.out.println(Krishna.getFullName());
        System.out.println(Krishna.getGender());
        System.out.println(Krishna.getSalary());
        System.out.println(Krishna.getCityName());


        System.out.println(balaram.getFirstname());
        System.out.println(balaram.getLastname());
        System.out.println(balaram.getFullName());
        System.out.println(balaram.getGender());
        System.out.println(balaram.getSalary());
        System.out.println(balaram.getCityName());

    }

}
