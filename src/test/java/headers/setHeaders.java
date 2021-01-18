package headers;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class setHeaders {


    @Test
    public void variousHeaderSetRestAssured()
    {
        // add Header as key value
        RestAssured.given().header("content-type","JSON");
        RestAssured.given().headers("content-type","XML");

        // Add header as map where merge will not happen
        Map<String,String> m = new HashMap<>();
        m.put("authorisation","oath2.0");
        RestAssured.given().headers(m);

        // Add using header Class
        Header reqHeader = new Header("Etag","test");
        RestAssured.given().header(reqHeader);

        // Add using headers Class
        Header head = new Header("accept","xml");
        Header headRes = new Header("accept","json");
        Headers heaaaaaaaders = new Headers(head,headRes);
        RestAssured.given().headers(heaaaaaaaders);

        // Add header with multiple values
        RestAssured.given().headers("content","xml","json");

        // Change default behavior of Merging
        RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("content"));

        // Change overwrite behavior if not







    }
}
