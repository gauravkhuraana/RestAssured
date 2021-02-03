package examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class localDateInput {

    // Created by Gaurav Khurana
    @Test
    public void localDateOnly() throws JsonProcessingException {
        BookingPojo bpo = new BookingPojo();

        bpo.setFirstName("Hare");
        bpo.setLastName("Krishna");

        LocalDate currentDate = LocalDate.now();

        bpo.setCheckin(currentDate.plusDays(10).toString());
        bpo.setCheckout(currentDate.plusDays(16).toString());

        //POJO to Json
        ObjectMapper objM = new ObjectMapper();
        String s = objM.writerWithDefaultPrettyPrinter().writeValueAsString(bpo);
        System.out.println(s);


        // Json to POJO
        BookingPojo boPo = objM.readValue(s,BookingPojo.class);
                System.out.println("Passed checked in date is " + boPo.getCheckin());
                System.out.println("Passed check out date is " + boPo.getCheckout());



    }

    @Test
    public void checkForLocalDateTimeAlso() throws JsonProcessingException {
        BookingPojo bpj = new BookingPojo();

        bpj.setFirstName("Gaurav");
        bpj.setLastName("Khurana");


        LocalDateTime ldt = LocalDateTime.now();
        bpj.setCheckin(ldt.plusHours(2).toString());
        bpj.setCheckout(ldt.plusDays(2).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")));

        // pojo to json
        ObjectMapper objM = new ObjectMapper();
        String s = objM.writerWithDefaultPrettyPrinter().writeValueAsString(bpj);
        System.out.println(s);

        // json to pojo
        BookingPojo bp = objM.readValue(s,BookingPojo.class);
        System.out.println("Checked in time is "+ bp.getCheckin());
        System.out.println("Checked out time is "+ bp.getCheckout());




    }


}
