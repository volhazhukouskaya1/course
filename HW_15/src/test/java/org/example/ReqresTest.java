package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertTrue;

public class ReqresTest {

    //Status code запроса post
    @Test
    public void reqresPostStatusCode() {

        User user = User.builder()
                .name("Volha")
                .job("tester")
                .build();

        given()
                .body(user)
                .when()
                .log().all()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);

    }

    //Тело ответа Post
    @Test
    public void reqresBodyPost() {

        User user = User.builder()
                .name("Volha")
                .job("tester")
                .build();

        given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .log().all()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .body("createdAt", notNullValue())
                .body("name",equalTo(user.getName()))
                .body("job", equalTo(user.getJob()))
                .body("id",notNullValue());
    }

    //Status code запроса put
    @Test
    public void reqresStatusCodePut() {

        User user = User.builder()
                .name("Volha")
                .job("tester")
                .build();

        given()
                .body(user)
                .when()
                .log().all()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    //Тело ответа Put
    @Test
    public void reqresBodyPut() {

        User user = User.builder()
                .name("Volha")
                .job("tester")
                .build();

        given()
                .body(user)
                .header("Content-Type", "application/json")
                .when()
                .log().all()
                .put("https://reqres.in/api/user/2")
                .then()
                .log().all()
                .body("updatedAt", notNullValue())
                .body("name",equalTo(user.getName()))
                .body("job", equalTo(user.getJob()));
    }

    //Status code запроса delete
    @Test
    public void reqresStatusCodeDelete() {

        User user = User.builder()
                .name("Volha")
                .job("tester")
                .build();

        given()
                .body(user)
                .when()
                .log().all()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204);

    }

    //Тело ответа Delete
    @Test
    public void reqresBodyDelete() {

        User user = User.builder()
                .name("Volha")
                .job("tester")
                .build();

        Response response = given()
                .body(user)
                .when()
                .log().all()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204)
                .extract().response();

        //Проверка, что тело ответа пустое
        assertTrue(response.getBody().asString().isEmpty());
    }




}
