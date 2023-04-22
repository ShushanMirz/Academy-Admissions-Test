import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.Randomize;
import org.example.Test;

import java.lang.reflect.Method;
import java.util.List;

public class TestsTest {

    private String title;
    private Integer duration;
    private List<String> questions;


    Randomize random = new Randomize();

    public void initData() {

        title = random.getRndName();
        duration = 12;
       // questions = "";
    }
}
