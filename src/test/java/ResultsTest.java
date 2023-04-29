import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.*;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

 class ResultsTest extends Config {

     private String applicant;
     private String test;
     private String phase;
     private List<Answer> answers;

     Randomize random = new Randomize();
     Methods methods = new Methods();

    Result result;
    Answer answer = new Answer(" ", new ArrayList<>());
//     @BeforeMethod
//     public void initData () {
//         applicant = "",
//         test = " ",
//         phase = " ",
//         answers = answers
//
//
//     }

     @Test
    public void createResult() {

        List<Map<String, Object>> answers = new ArrayList<>();
        ArrayList<Object> filledAnswers = new ArrayList<Object>();
        filledAnswers.add("new");
        filledAnswers.add("a");
        answers.add(new HashMap<>() {{
            put("question", "64482398c900126672e50855");
            put("filledAnswers", filledAnswers);
        }});

        Map<String, Object> body = new HashMap<>() {{
            put("applicant", "644824b1c900126672e50860");
            put("test", "64482398c900126672e50855");
            put("phase", "644823e9c900126672e5085b");
            put("answers", answers);

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
                //header("Content-Type","application/json").
                header("Authorization", token).
                body(jsonString).
        when().
                post(AllEndpoints.All_Results).
        then().
                log().
                all().
                assertThat().statusCode(201);

    }

}

