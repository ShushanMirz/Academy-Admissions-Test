import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ApplicantEndpoint;
import org.example.Config;
import org.example.EventEndpoint;
import org.example.Randomize;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class EventTest extends Config {
    Randomize randomize = new Randomize();

     @Test
     public void verifyCreateEvent () {


             List<Map<String, Object>> interviewers = new ArrayList<>();
             List<Map<String, Object>> schedule = new ArrayList<>();
             List<Map<String, String>> intervals = new ArrayList<>();
             interviewers.add(new HashMap<>() {{
                 put("interviewer", "64342990cd04f09aee0449c3");
                 put("schedule", schedule);

             }});
             interviewers.add(new HashMap<>() {{
             put("interviewer","64441837f0b87e58349b972c");
             put("schedule", schedule);
             }});
             schedule.add(new HashMap<>() {{
                 put("date", randomize.getRandomTimestampStr());
                 put("intervals", intervals);

             }});
             intervals.add(new HashMap<>() {{
                 put("start", "12:00");
                 put("end", "18:00");

             }});

             Map<String, Object> body = new HashMap<>() {{
                 put("name", "string11");
                 put("type", "string");
                 put("start", randomize.getRandomTimestampStr());
                 put("end", randomize.getRandomTimestampStr());
                 put("description", "string");
                 put("smsReminder", "string");
                 put("duration", 15);
                 put("interviewers", interviewers);
             }};


             ObjectMapper objectMapper = new ObjectMapper();
             String jsonString = "";
             try {
                 jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
             } catch (Exception e) {
                 e.printStackTrace();
             }

         given().
                 body(jsonString).
                 when().
                 post(EventEndpoint.All_Events).
                 then().
                 assertThat().statusCode(201);

         }


     }

