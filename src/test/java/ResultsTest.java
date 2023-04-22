import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResultsTest {

    @Test
    public void aCarGoesIntoTheGarage() {
        Map<String,String> car = new HashMap<>();
        car.put("plateNumber", "xyx1111");
        car.put("brand", "audi");
        car.put("colour", "red");

        given()
                .contentType("application/json")
                .body(car)
                .when().post("/garage/slots").then()
                .statusCode(200);
    }
}
