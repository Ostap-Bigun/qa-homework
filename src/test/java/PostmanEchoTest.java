import io.restassured.config.EncoderConfig;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class PostmanEchoTest {

    @Test
    void getRequestTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get")
                .then().log().all()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));


    }

    @Test
    void postRawTextTest() {
        given().contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("https://postman-echo.com/post")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    void postFormDataTest() {

        given()
                .config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("https://postman-echo.com/post")
                .then().log().all()
                .statusCode(200)
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    void putRequestTest() {
        given().contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("https://postman-echo.com/put")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));


    }

    @Test
    void patchRequestTest() {
        given().contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("https://postman-echo.com/patch")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));


    }

    @Test
    void DeleteRequestTest() {
        given().contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("https://postman-echo.com/delete")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));


    }
}