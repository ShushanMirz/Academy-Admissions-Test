import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PhasesTest {

    @Test
    public void createPhase() {
        String endpoint = "http://localhost:3000/phases";
        String body = """ 
                { 
                 "name": "The second phase"
                 }
                """;
        var response =
                given().
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        post(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void getPhases() {
        String endpoint = "http://localhost:3000/phases";
        var response =
                given().
                        when().
                        get(endpoint).
                        then();
        response.log().body();


    }

    @Test
    public void  getPhase () {
        String endpoint = "http://localhost:3000/phases/{id}";
        var response =
                given().
                        pathParam("id", "6432d93c727a4414200ffb9e").
                        when().
                        get(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void updatePhase() {
        String endpoint = "http://localhost:3000/phases/{id}";
        String body = """ 
                { 
                 "name": "The updated phase 2"
                }
                """;
        var response =
                given().
                        pathParam("id", "6432dcf4727a4414200ffba2").
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        patch(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void deletePhase() {
        String endpoint = "http://localhost:3000/phases/{id}";
        var response =
                given().
                        pathParam("id", "6432d93c727a4414200ffb9e").
                        when().
                        delete(endpoint).
                        then();
        response.log().body();


    }


}
