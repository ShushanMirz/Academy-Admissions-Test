import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.AllEndpoints;
import org.example.Config;
import org.example.Methods;
import org.example.Randomize;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class TestsTest extends Config {

    private String title = " ";
    private int duration = 0;

    Randomize random = new Randomize();
    Methods methods = new Methods();

    org.example.Test test;


    @Test  public void createTest() {

            List<Map<String, Object>> questions = new ArrayList<>();
            ArrayList<Object> answers = new ArrayList<Object>();
            ArrayList<Object> correctAnswers = new ArrayList<Object>();
            questions.add(new HashMap<>() {{
                put("type", "string");
                put("question", "string");
                put("required", true);
                put("image", "string");
                put("answers", answers);
                put("correctAnswers", correctAnswers);
                put("maxScore", 10);
            }});

                answers.add(1);
                answers.add("a");
                correctAnswers.add(1);
                correctAnswers.add("b");

            Map<String, Object> body = new HashMap<>() {{
                put("title", "String11");
                put("duration", 10);
                put("questions", questions);

            }};


            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = "";
            try {
                jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
            } catch (Exception e) {
                e.printStackTrace();

            }
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im1pcnpha2hhbnlhbnNodXNoYW5AZ21haWwuY29tIiwiaWQiOiI2NDM0Mjk5MGNkMDRmMDlhZWUwNDQ5YzMiLCJpYXQiOjE2ODI0NDczNzcsImV4cCI6MTY4NTAzOTM3N30.r3-59YmaWCQhM8NKbGAcjAlqfhub61CjytRbCBqP_tY";

        given().
                header("Authorization", token).
                    body(jsonString).
            when().
                    post(AllEndpoints.All_Tests).
            then().
                    assertThat().statusCode(201);

        }

}

