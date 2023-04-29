import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;

public class UsersTest extends Config {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private  String phone;

    Randomize random = new Randomize();
    Methods methods = new Methods();
    User user;

    @BeforeMethod
    public void initData(Method methodName) {

        firstName = random.getRndName();
        lastName = random.getRndName();
        email = random.getRndEmail();
        phone = "+374" + random.getRunPhoneValid();
        role = " ";
        password = " ";


        user  = new User(
                firstName,
                lastName,
                email,
                password,
                role,
                phone

        );
    }
    @Test
    public void verifyCreateUserAdmin() {



                given().
                        body(methods.toJsonString(user)).
                when().
                        post(AllEndpoints.All_Users).
                then();

    }


    @Test
    public void verifyCreateUserUnauthorized() {


        given().
                body(methods.toJsonString(user)).
                when().
                post(AllEndpoints.All_Users).
                then();

    }
        @Test
        public void verifyCreateUserAdminSameEmail() {

        //should take already existed email
         given().
                    body(methods.toJsonString(user)).
         when().
                    post(AllEndpoints.All_Users).
         then();

        }

    @Test
    public void verifyGetUserID() {

        //should take already existed email
        given().
                body(methods.toJsonString(user)).
        when().
                get(AllEndpoints.Single_User).
        then();

    }

}

//    @Test
//    public void createSerializedUser() throws JsonProcessingException {
//        String endpoint = "http://localhost:3000/users";
//        User user = new User(
//                "Shushan",
//                "Mirzakhanyan",
//                "mirzakhanyanshushan@gmail.com",
//                "Shushan12",
//                "Admin"
//        );
//        //String jsonBody = user.toJsonString();
//        var response =
//                given().
//                        header("Content-Type", "application/json").
//                        body(user).
//                        when().
//                        post(endpoint).
//                        then();
//        response.log().body();
//
//
//    }

//    @Test
//
//    public void getUsers() {
//        String endpoint = "http://localhost:3000/users";
//        var response = given().when().get(endpoint).then();
//    }


//    @Test
//
//    public void getUser() {
//        String endpoint = "http://localhost:3000/users/{id}";
//        var response =
//                given().
//                        pathParam("id", "64329ea0727a4414200ffb88").
//                        when().
//                        get(endpoint).
//                        then();
//        response.log().body();
//
//    }

//    @Test
//    public void updateUser() {
//        String endpoint = "http://localhost:3000/users/{id}";
//        String body = """
//                {
//                   "role": "Admin"
//                }
//                """;
//        var response =
//                given().
//                        pathParam("id", "64342990cd04f09aee0449c3").
//                        header("Content-Type", "application/json").
//                        body(body).
//                        when().
//                        patch(endpoint).
//                        then();
//        response.log().body();
//
//    }

//    @Test
//    public void deleteUser() {
//        String endpoint = "http://localhost:3000/users/{id}";
//        var response =
//                given().
//                        pathParam("id", "64329ea0727a4414200ffb88").
//                        when().
//                        delete(endpoint).
//                        then();
//        response.log().body();
//
//
//    }


