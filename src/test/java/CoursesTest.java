import org.example.Methods;
import org.example.Randomize;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import static io.restassured.RestAssured.given;

public class CoursesTest {

    Randomize random = new Randomize();
    Methods methods = new Methods();

    @Test
    public void createCourse(ITestContext context) {
        String endpoint = "http://localhost:3000/courses";
        String body = """
                { "title": "New course 2",
                   "description": "string",
                   "resources": {
                   "title": "string",
                   "url": "https://www.youtube.com/watch?v=e74zROBrIKg"
                       }
                  }
                  
                """;
                given().
                        header("Content-Type", "application/json").
                        body(body).
                when().
                        post(endpoint).
                        then()
                        .log()
                        .all()
                        .extract()
                        .jsonPath().get("message");

//        context.setAttribute("applicantId", applicantId);
//        System.out.println(applicantId);

    }



    @Test
    public void getCourses() {
        String endpoint = "http://localhost:3000/courses";
        var response =
                given().
                        when().
                        get(endpoint).
                        then();
        response.log().body();


    }

    @Test
    public void  getCourse () {
        String endpoint = "http://localhost:3000/courses/{id}";
        var response =
                given().
                        pathParam("id", "6432dddb727a4414200ffba8").
                        when().
                        get(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void updateCourse() {
        String endpoint = "http://localhost:3000/courses/{id}";
        String body = """ 
                {
                    "name": "New updated Course",
                    "phases": [
                      "643190cbfdcac23e6b077351"
                    ]
                }
                """;
        var response =
                given().
                        pathParam("id", "6432dddb727a4414200ffba8").
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        put(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void deleteCourse() {
        String endpoint = "http://localhost:3000/courses/{id}";
        var response =
                given().
                        pathParam("id", "6432d93c727a4414200ffb9e").
                        when().
                        delete(endpoint).
                        then();
        response.log().body();


    }

}

