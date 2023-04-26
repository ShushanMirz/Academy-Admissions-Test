import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.AllEndpoints;
import org.example.Config;
import org.example.Randomize;
import org.testng.annotations.Test;
import java.util.*;
import static io.restassured.RestAssured.given;

public class EventsTest extends Config {
    Randomize randomize = new Randomize();

     @Test
     public void verifyCreateEvent () {


         List<Map<String, Object>> interviewers = new ArrayList<>();
         List<Map<String, Object>> schedules = new ArrayList<>();
         List<Map<String, String>> intervals = new ArrayList<>();
         interviewers.add(new HashMap<>() {{
             put("interviewer", "64342990cd04f09aee0449c3");
             put("schedules", schedules);

         }});
         schedules.add(new HashMap<>() {{
             put("weekDay", "Monday");
             put("intervals", intervals);

         }});
         intervals.add(new HashMap<>() {{
             put("start", "12:00");
             put("end", "14:00");

         }});

         Map<String, Object> body = new HashMap<>() {{
             put("name", "Event 1");
             put("type", "one and one");
             put("start", "2023-12-31T23:59:59.999+04:00");
             put("end", "2024-12-31T23:59:59.999+04:00");
             put("description", "Description of event");
             put("smsReminder", "15 minutes");
             put("emailReminder", "15 minutes");
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
                 post(AllEndpoints.All_Events).
                 then().
                 assertThat().statusCode(201);
     }

//             @Test
//                     public void deleteEvent() {
//                 given().
//                        pathParam("eventId","644958d27b845b5eab714237").
//                        when().
//                        delete(AllEndpoints.Single_Event).
//                        then().log().all();
//         }

         }



