package api;

import api.pojo.User;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class RestTest {
    Logger log = LoggerFactory.getLogger(getClass());
    private static final String TOKEN = "91063e9e61eaae22c5b5a3f4564e15a179e43753add85c1d8678ca6fd19464d7";
    FakeValuesService fakeValuesService;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
    }

    @Test
    void get_users_no_auth() {
        log.info("check list of users without authorization");
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(1));
    }

    @Test
    void get_user_with_auth() {
        log.info("check single user with bearer authorization");
        RequestSpecification getUsersSpec = new RequestSpecBuilder()
                .setAuth(oauth2(TOKEN))
                .setBaseUri(baseURI)
                .setBasePath("/users")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();

        given()
                .spec(getUsersSpec)
                .when()
                .get("/5101")
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo("Deeen Pen"));
    }

    @Test
    @Disabled
    void post_user_raw_json() {
        log.info("create user with POST raw body");
        given()

                .auth().oauth2(TOKEN)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"Deeen Pen\",\n" +
                        "    \"email\": \"sodt69@mail.yep\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    void post_user_from_file() throws IOException {
        log.info("create user with POST from json file");
        String fileContent = Files.readString(Path.of("src/test/java/api/PostUser.json"));

        int newUserID = given()
                .auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(fileContent)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .extract()
                .path("id");

        log.info("new user ID = " + newUserID);
    }

    @Test
    void post_user_from_object() {
        User user = new User();

        String email = fakeValuesService.bothify("so??##@mail.yep");
        user.setEmail(email);

        User resultUser = given()
                .auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .log().body()
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .extract()
                .as(User.class);

        log.info("result user = " + resultUser.getId() + " " + resultUser.getName());
    }

    @Test
    void post_user_from_JSONobject() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Deeen Pen");
        jsonObject.put("email", fakeValuesService.bothify("so??##@mail.yep"));
        jsonObject.put("gender", "male");
        jsonObject.put("status", "active");

        User resultUser = given()
                .auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toString())
                .log().body()
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .extract()
                .body()
                .as(User.class);

        log.info("result user = " + resultUser.getId() + " " + resultUser.getName());
    }

    @Test
    void get_users_to_object() {
        log.info("check all users with bearer authorization");
        User[] users = given()
                .auth().oauth2(TOKEN)
                .when()
                .get("/users")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .body()
                .as(User[].class);

        log.info(Arrays.toString(users));
    }

    @Test
    void get_users_response_to_object() {
        log.info("check GET users without authorization");
        List<Map<String, Object>> responseBody;
        responseBody =
                RestAssured
                        .when()
                        .get("/users")
                        .then()
                        .log().body()
                        .statusCode(200)
                        .extract()
                        .as(new TypeRef<List<Map<String, Object>>>() {
                        });

        log.debug("size: " + responseBody.size());
        log.info(responseBody.toString());
    }


}
