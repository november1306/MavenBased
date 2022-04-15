package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class StarWarsApiTest {

    Logger log = LoggerFactory.getLogger(StarWarsApiTest.class);

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://swapi.dev";
    }

    @Test
    public void getPeopleTest() {
        Response response = RestAssured.get();
        log.info(response.prettyPrint());
    }

    @Test
    public void checkR2D2mass() {
        when().get("https://swapi.dev/api/people/3")
                .then()
                .statusCode(200)
                .assertThat()
                .body("mass", equalTo("32"));
    }
}
