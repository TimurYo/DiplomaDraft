package data;

import io.restassured.http.ContentType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import static io.restassured.RestAssured.given;


@NoArgsConstructor
public class ApiBodyObject {

    @Value
    public static class ApiBody {
        public String number;
        public String year;
        public String month;
        public String holder;
        public String cvc;
    }

    public static String getGivenWithPayApprovedCard() {
        ApiBody body = new ApiBody("4444 4444 4444 4441","24","12","fgfgfgfg","333");
        return given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .body(body)
                .when()
                .post("/api/v1/pay")
                .then()
                .statusCode(200)
                .extract().response().asString();
    }

    public static String getGivenWithPayDeclinedCard() {
        ApiBody body = new ApiBody("4444 4444 4444 4442","24","12","fgfgfgfg","333");
        return given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .body(body)
                .when()
                .post("/api/v1/pay")
                .then()
                .statusCode(200)
                .extract().response().asString();
    }

    public static String getGivenWithCreditApprovedCard() {
        ApiBody body = new ApiBody("4444 4444 4444 4441","24","12","fgfgfgfg","333");
        return given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .body(body)
                .when()
                .post("/api/v1/credit")
                .then()
                .statusCode(200)
                .extract().response().asString();
    }

    public static String getGivenWithCreditDeclinedCard() {
        ApiBody body = new ApiBody("4444 4444 4444 4442","24","12","fgfgfgfg","333");
        return given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .body(body)
                .when()
                .post("/api/v1/credit")
                .then()
                .statusCode(200)
                .extract().response().asString();
    }


}


