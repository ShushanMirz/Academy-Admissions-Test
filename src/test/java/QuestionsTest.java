import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.AllEndpoints;
import org.example.Config;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class QuestionsTest extends Config {
    @Test
    public void createQuestion()
    {

        ArrayList<String> answers = new ArrayList<String>();
        ArrayList<Object> correctAnswers = new ArrayList<Object>();
        answers.add("a");
        answers.add("b");
        correctAnswers.add("a");
        correctAnswers.add("d");


        Map<String, Object> body = new HashMap<>() {{
            put("test", "64482398c900126672e50855");
            put("type", "singleChoice");
            put("question", "string");
            put("required", true);
            put("maxScore", 100);
            //put("questionImage", "string");
            put("answers", answers);
            put("correctAnswers", correctAnswers);

        }};

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im1pcnpha2hhbnlhbnNodXNoYW5AZ21haWwuY29tIiwiaWQiOiI2NDM0Mjk5MGNkMDRmMDlhZWUwNDQ5YzMiLCJpYXQiOjE2ODI0NDczNzcsImV4cCI6MTY4NTAzOTM3N30.r3-59YmaWCQhM8NKbGAcjAlqfhub61CjytRbCBqP_tY";
        given().header("Authorization", token ).
                body(jsonString)
                .when().
                post(AllEndpoints.All_Questions)
                .then()
                .assertThat().statusCode(201);

    }
}
