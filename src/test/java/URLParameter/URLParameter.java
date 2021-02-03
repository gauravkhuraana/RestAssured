package URLParameter;

import io.restassured.RestAssured;
import org.junit.Test;

public class URLParameter {


    @Test
    public void pathParamVarible()
    {
        RestAssured
                .given()
                  .log()
                  .all()
                  .baseUri("https://restful-booker.herokuapp.com/")
                // good to separate this parameter and base URI
                  .basePath("{resourcePath}")
                  .pathParam("resourcePath","booking")
                .when()
                  .get()
                .then()
                  .log()
                  .all();
    }


    @Test
    public void pathParamVaribleInvalid()
    {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/{resourcePath}")
                // This will give error since we did not used basePath for resourcePath Varible - URISyntax Exception
                .pathParam("resourcePath","booking")
                .when()
                .get()
                .then()
                .log()
                .all();
    }

    @Test
    public void path()
    {
        RestAssured
              .given()
                .log()
                .all()
                .pathParam("resourcePath","booking")
              .when()
                 .get("https://restful-booker.herokuapp.com/{resourcePath}")
              .then()
                  .log()
                  .all();
    }

    @Test
    public void inlinePathVariable()
    {
        RestAssured
                 .given()
                     .log()
                     .all()
                .when()
                   .get("https://restful-booker.herokuapp.com/{resourcePath}","booking")
                .then()
                    .log()
                    .all();
    }

    @Test
    public void multipleInlinePathVariable()
    {
        RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://restful-booker.herokuapp.com/{resourcePath}/{booking}","booking",10)
                .then()
                .log()
                .all();
    }


    @Test
    public void mixParameter()
    {

        RestAssured
                .given()
                  .log()
                  .all()
                  .pathParam("resourcePath","booking")
                .when()
                  .get("https://restful-booker.herokuapp.com/{resourcePath}/{booking}",10)
                .then()
                  .log()
                  .all();
    }
}
