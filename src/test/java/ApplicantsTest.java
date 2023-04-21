import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.example.Applicant;
import org.example.Config;
import org.example.Randomize;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApplicantsTest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private boolean isWarVeteran;
    private boolean isLessThan16;
    private String courseId;

    Randomize random = new Randomize();
    Config config = new Config();
    String endpoint = config.getApplicantEnd();
    String courseEndpoint = config.getCourseEnd();

    @BeforeMethod

    public void initData(Method methodName) {

        firstName = random.getRndName();
        lastName = random.getRndName();
        middleName = random.getRndName();
        email = random.getRndEmail();
        phone = "+374" + random.getRunPhoneValid();
        isWarVeteran = random.getRndBool();
        isLessThan16 = random.getRndBool();
        courseId = "643fe26ed68f43c6e39d1f00";
    }



//        public void getCoursesIdForCreationApplicant(ITestContext context) {
//            List<String> validCourseId =
//                    given().
//                    when().
//                            get(courseEndpoint).
//                    then().
//                    log().
//                    all().
//                    extract().
//                    jsonPath().
//                    get();
//            context.setAttribute("validCourseId", validCourseId);
//}






    @Test
    public void verifyCreateApplicant(ITestContext context) {

        Applicant applicant = new Applicant(
                firstName,
                lastName,
                middleName,
                email,
                phone,
                isWarVeteran,
                isLessThan16,
                courseId
        );
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(applicant);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RestAssured.given().
                header("Content-Type", "application/json").
                body(jsonString).
                when().
                post(endpoint).
                then().
                log().body().
                assertThat().statusCode(201).
                body("id", is(notNullValue())).
                body("passcode", is(notNullValue()));

        //is that ok, to check that value is not empty

        System.out.println(phone);


    }
    @Test
    public void verifyCreateApplicantEmptyData(ITestContext context) {

        Applicant applicant = new Applicant(
                firstName = " ",
                lastName = " ",
                middleName = " ",
                email = " ",
                phone = " ",
                isWarVeteran,
                isLessThan16,
                courseId = " "
        );
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(applicant);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RestAssured.given().
                header("Content-Type", "application/json").
                body(jsonString).
                when().
                post(endpoint).
                then().
                log().body().
                assertThat().statusCode(400).
                body("error", equalTo("Bad Request"));
        //         should I check all type of messages, example  "firstName must be longer than or equal to 2 characters",
        //        "lastName must be longer than or equal to 2 characters",
        //        "middleName must be longer than or equal to 2 characters",
        //        "email must be an email",
        //        "email must be longer than or equal to 2 characters",
        //        "phone must be a valid phone number",
        //        "courseId must be a mongodb id"
    }

    @Test
    public void verifyCreateApplicantEmailNotValid() {

        Applicant applicant = new Applicant(
                firstName,
                lastName,
                middleName,
                email = random.getRndName(),
                phone,
                isWarVeteran,
                isLessThan16,
                courseId
        );
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(applicant);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RestAssured.given().
                header("Content-Type", "application/json").
                body(jsonString).
                when().
                post(endpoint).
                then().
                assertThat().statusCode(400).
                body("message[0]", equalTo("email must be an email"));

    }

    @Test

    public void verifyCreateApplicantPhoneNotValid() {

        Applicant applicant = new Applicant(
                firstName,
                lastName,
                middleName,
                email,
                phone = random.getRndWrongNum(),
                isWarVeteran,
                isLessThan16,
                courseId
        );
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(applicant);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RestAssured.given().
                header("Content-Type", "application/json").
                body(jsonString).
                when().
                post(endpoint).
                then().
                log().body().
                assertThat().statusCode(400).
                body("message[0]", equalTo("phone must be a valid phone number"));



    }
    @Test
    public void verifyCreateApplicantCourseNotFound() {

        Applicant applicant = new Applicant(
                firstName,
                lastName,
                middleName,
                email,
                phone,
                isWarVeteran,
                isLessThan16,
                courseId = random.getRndId()
        );
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(applicant);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RestAssured.given().
                header("Content-Type", "application/json").
                body(jsonString).
                when().
                post(endpoint).
                then().
                assertThat().statusCode(400).
                body("message[0]", equalTo("courseId must be a mongodb id"));

    }


    @Test
    public void getApplicants() {
        given().
        when().
                get(endpoint).
        then(). log().body().
                assertThat().statusCode(200);

    }

//    public void getValidApplicant() {
//
//        String applicantId = (String) context.getAttribute("applicantId");
//        System.out.println(applicantId);
//        String endpoint = "http://localhost:3000/applicants/{applicantId}";
//
//        given().
//                pathParam("applicantId", applicantId).
//
//                when().
//                get(endpoint).
//                then();
//    }
//
//
//    @AfterMethod
//    public void updateApplicant(ITestContext context) {
//        String applicantId = (String) context.getAttribute("applicantId");
//        String endpoint = "http://localhost:3000/users/{applicantId}";
//        String body = """
//                 {
//                 "firstName": "Shush",
//                 "lastName": "Mirzakhan",
//                 "middleName": "Atom",
//                 "email": "mirzakhanyanshushan@gmail.com",
//                 "phone": "+37498775544",
//                 "isWarVeteran": true,
//                 "isLessThan16": true
//                }
//                """;
//        var response =
//                given().
//                        pathParam("applicantId", applicantId).
//                        header("Content-Type", "application/json").
//                        body(body).
//                        when().
//                        patch(endpoint).
//                        then();
//
//    }
//
//
//    @AfterMethod
//    public void deleteApplicant(ITestContext context) {
//        String applicantId = (String) context.getAttribute("applicantId");
//        String endpoint = "http://localhost:3000/applicants/{applicantId}";
//        var response =
//                given().
//                        pathParam("applicantId", applicantId).
//                        when().
//                        delete(endpoint).
//                        then();
//        response.log().body();
//
//
//    }
}



