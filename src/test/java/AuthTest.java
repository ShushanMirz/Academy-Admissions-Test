import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthTest {

    @Test
    public void authLogin(ITestContext context) {
        String endpoint = "http://localhost:3000/auth/login";
        String body = """ 
                { 
                 "email": "mirzakhanyanshushan@gmail.com",
                 "password": "Shushan12"
                }
                """;
        String token =
                given().
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        post(endpoint).
                        then().
                        log().
                        all().
                        extract().
                        jsonPath().
                        get("access_token");

        context.setAttribute("token", token);
        System.out.println(token);

    }
}
