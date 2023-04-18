import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersTest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;




    @BeforeMethod
    public void initData() {
        firstName = "Shushan";
        lastName = "Mirzakhanyan";
        email = "mirzakhanyanshushan@gmail.com";
        password = "Aa123456";
        role = "User";

    }
    @Test
    public void createUser() {
        String endpoint = "http://localhost:3000/users";
        User user = new User(
                firstName,
                lastName,
                email,
                password,
                role
        ) ;

        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        var response =
                given().
                        header("Content-Type", "application/json").
                        body(jsonString).
                        when().
                        post(endpoint).
                        then();
        response.log().body();
    }

    @Test
    public void createSerializedUser() throws JsonProcessingException {
        String endpoint = "http://localhost:3000/users";
        User user = new User(
                "Shushan",
                "Mirzakhanyan",
                "mirzakhanyanshushan@gmail.com",
                "Shushan12",
                "Admin"
        );
        //String jsonBody = user.toJsonString();
        var response =
                given().
                        header("Content-Type", "application/json").
                        body(user).
                        when().
                        post(endpoint).
                        then();
        response.log().body();


    }

    @Test

    public void getUsers() {
        String endpoint = "http://localhost:3000/users";
        var response = given().when().get(endpoint).then();
    }


    @Test

    public void getUser() {
        String endpoint = "http://localhost:3000/users/{id}";
        var response =
                given().
                        pathParam("id", "64329ea0727a4414200ffb88").
                        when().
                        get(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void updateUser() {
        String endpoint = "http://localhost:3000/users/{id}";
        String body = """ 
                { 
                   "role": "Admin"
                }
                """;
        var response =
                given().
                        pathParam("id", "64342990cd04f09aee0449c3").
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        patch(endpoint).
                        then();
        response.log().body();

    }

    @Test
    public void deleteUser() {
        String endpoint = "http://localhost:3000/users/{id}";
        var response =
                given().
                        pathParam("id", "64329ea0727a4414200ffb88").
                        when().
                        delete(endpoint).
                        then();
        response.log().body();


    }
}

