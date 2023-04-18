import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.testng.ITestContext;

public class NotesTest {
    @Test
    public void createNote(ITestContext context) {
        String endpoint = "http://localhost:3000/note";
        String body = """ 
                { 
                 "name": "The first note"
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
                 "name": "The updated phase"
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
