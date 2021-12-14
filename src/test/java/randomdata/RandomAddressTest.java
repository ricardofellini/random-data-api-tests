package randomdata;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;


public class RandomAddressTest {

    @BeforeEach
    public void beforeEachTest(){
        RestAssured.baseURI = "https://random-data-api.com/api/address";
    }


    @Test
    @DisplayName("Random Address - TEST")
    public void randomAddressTest(){

        var responseData = given()
            .contentType(ContentType.JSON)
        .when()
            .get("/random_address")
        .then()
                .assertThat().statusCode(SC_OK)
                .log().all()
                .body("id", notNullValue());
    }
}
