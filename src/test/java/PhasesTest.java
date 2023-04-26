import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.AllEndpoints;
import org.example.Config;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class PhasesTest extends Config {
    @Test
            public void createPhase()
        {
            Map<String, Object> body = new HashMap<>() {{
                put("type", "initial");
                put("title", "Initial event");
                put("description", "string");
                put("body", "string");
                put("start", "2023-04-23T16:34:55.742Z");
                put("end", "2021-04-23T16:34:55.742Z");
                //put("test", "64482398c900126672e50855");
                //put("event", "6444016e1b3ede4ac0c6a337");
                put("emailOnStart", false);
                put("smsOnStart", false);
                put("emailOnSuccess", false);
                put("smsOnSuccess", false);
                put("emailOnRejection", false);
                put("smsOnRejection", false);
                put("course", "6449527033002ff8a701ede1");

            }};

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = "";
            try {
                jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
            } catch (Exception e) {
                e.printStackTrace();
            }

            given().
                    body(jsonString)
            .when().
                    post(AllEndpoints.All_Phases)
            .then()
                    .assertThat().statusCode(201);

        }



//
//    @Test
//    public void createPhase() {
//        String endpoint = "http://localhost:3000/phases";
//        String body = """
//                {
//
//                  "emailOnSuccess": true,
//                  "smsOnSuccess": true,
//                  "emailOnRejection": true,
//                  "smsOnRejection": true,
//                  "course": "string"
//                }
//                """;
//        var response =
//                given().
//                        header("Content-Type", "application/json").
//                        body(body).
//                        when().
//                        post(endpoint).
//                        then();
//        response.log().body();
//
//    }
//
//    @Test
//    public void getPhases() {
//        String endpoint = "http://localhost:3000/phases";
//        var response =
//                given().
//                        when().
//                        get(endpoint).
//                        then();
//        response.log().body();
//
//
//    }
//
//    @Test
//    public void  getPhase () {
//        String endpoint = "http://localhost:3000/phases/{id}";
//        var response =
//                given().
//                        pathParam("id", "6432d93c727a4414200ffb9e").
//                        when().
//                        get(endpoint).
//                        then();
//        response.log().body();
//
//    }
//
//    @Test
//    public void updatePhase() {
//        String endpoint = "http://localhost:3000/phases/{id}";
//        String body = """
//                {
//                 "name": "The updated phase 2"
//                }
//                """;
//        var response =
//                given().
//                        pathParam("id", "6432dcf4727a4414200ffba2").
//                        header("Content-Type", "application/json").
//                        body(body).
//                        when().
//                        patch(endpoint).
//                        then();
//        response.log().body();
//
//    }
//
//    @Test
//    public void deletePhase() {
//        String endpoint = "http://localhost:3000/phases/{id}";
//        var response =
//                given().
//                        pathParam("id", "6432d93c727a4414200ffb9e").
//                        when().
//                        delete(endpoint).
//                        then();
//        response.log().body();
//
//
//    }


}
