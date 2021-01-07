package examples;

import com.google.common.io.Files;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WriteRestAPI_Response_to_external_Files {

    RequestSpecification req;
    Response res;
@BeforeClass
public void writeResponseToFile()
    {
        String jsonString = "{ \"username\":\"admin\" , \"password\":\"password123\" }" ;

        RequestSpecification req = RestAssured.given();

        req.baseUri("https://restful-booker.herokuapp.com/auth");
        req.contentType(ContentType.JSON);
        req.body(jsonString);

        res = req.post();
        File target = new File("src/main/resources/targeFileForStringGetBytes");


    }

    @Test
    public void testcase1_writeUsingStringMehod() throws IOException {
        String resAsString = res.asString();
        byte[] resAsBytes = resAsString.getBytes();

        File target = new File("src/main/resources/targeFileForStringGetBytes");

        // what to write and where to write
        // Files not file
        Files.write(resAsBytes,target);


    }

    @Test
    public void tc2_writeUsingAsInputStream() throws IOException {
        InputStream ist = res.asInputStream();
        byte[] resAsInputStream = new byte[ist.available()];
        ist.read(resAsInputStream);

        File target = new File("src/main/resources/fileViaInputStream");

        Files.write(resAsInputStream,target);

    }

    @Test
    public void bestWayToPrintOutputResponseToFile() throws IOException {
        byte[] byteRes = res.asByteArray();

        File fileForSimplestWay = new File("src/main/resources/fileViaByteArray");

        Files.write(byteRes,fileForSimplestWay);


    }


}
