import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class EventTest {

    public static void main(String[] args) {

        List<Map<String, Object>> interviewers = new ArrayList<>();
        List<Map<String, Object>> schedule = new ArrayList<>();
        List<Map<String, String>> intervals = new ArrayList<>();
        interviewers.add(new HashMap<>() {{
            put("interviewer", "string");
            put("schedule", schedule );

        }});

        schedule.add(new HashMap<>() {{
            put("date", "string");
            put("intervals", intervals );

        }});
        intervals.add(new HashMap<>() {{
            put("start", "string");
            put("end", "string" );

        }});

        Map <String, Object> body = new HashMap<>() {{
            put("name", "string");
            put("type", "string");
            put("start", "string");
            put("end", "string");
            put("description", "string");
            put("smsReminder", "string");
            put("duration", "string");
            put("interviewers", interviewers);
        }};

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
            System.out.println(json);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(body);
    }


}
