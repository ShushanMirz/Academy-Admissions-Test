import org.example.Methods;
import org.example.Randomize;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.testng.ITestContext;

public class NotesTest {

    private String subject;
    private String applicant;
    private String text;
    private String courseTitle;


    Randomize random = new Randomize();
    Methods methods = new Methods();
    @Test
    public void createNote(ITestContext context) {
        String endpoint = "http://localhost:3000/note";
        String body = """ 
                {
                  "subject": "string",
                  "author": "string",
                  "applicant": "string",
                  "text": "string",
                  "courseTitle": "string"
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
    public void getNotes() {
        String endpoint = "http://localhost:3000/note/getAll";
        var response =
                given().
                        when().
                        get(endpoint).
                        then();
        response.log().body();


    }

    @Test
    public void  getNote () {
        String endpoint = "http://localhost:3000/note/get/{id}";
        var response =
                given().
                        pathParam("id", " ").
                        when().
                        get(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void updateNote() {
        String endpoint = "http://localhost:3000/note/{id}";
        String body = """ 
                {
                   "subject": "string",
                   "author": "string",
                   "applicant": "string",
                   "text": "string",
                   "courseTitle": "string"
                 }
                """;
        var response =
                given().
                        pathParam("id", "6432d93c727a4414200ffb9e").
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        put(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void deleteNote() {
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

