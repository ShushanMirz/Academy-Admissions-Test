import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApplicantsTest extends Config {

    private String firstName = " ";
    private String lastName = " ";
    private String middleName = " ";
    private String email = " ";
    private String phone = " ";
    private boolean isWarVeteran = true;
    private boolean isLessThan16 = true;
    private String courseId = " ";

    Randomize random = new Randomize();

    Applicant applicant = new Applicant(
            firstName = random.getRndName(),
            lastName = random.getRndName(),
            middleName = random.getRndName(),
            email = random.getRndEmail(),
            phone = "+374" + random.getRunPhoneValid(),
            isWarVeteran = random.getRndBool(),
            isLessThan16 = random.getRndBool(),
            courseId = "6449527033002ff8a701ede1"
    );

    Methods methods = new Methods();

    @BeforeMethod
    public void setToken (Method methodName) {


    }



//    @BeforeMethod
//    public void initData(Method methodName) {
//
//        firstName = "Shushan";
//        lastName = "Mirzakhanyan";
//        middleName = "Atom";
//        email = "mirzakhanyanshushan@gmail.com";
//        phone = "+37498775545";
//        isWarVeteran = random.getRndBool();
//        isLessThan16 = random.getRndBool();
//        courseId = "6449527033002ff8a701ede1";
//    }



    @Test
    public void verifyCreateAppNoAuth(ITestContext context) {

//
//        String jsonString = "";
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            jsonString = mapper.writeValueAsString(applicant);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }


        given().
                body(methods.toJsonString(applicant)).

        when().
               post(AllEndpoints.All_Applicants).
        then().
                assertThat().statusCode(201).
                body("message", equalTo("Applicant successfully registered."));



    }
    @Test
    public void verifyCreateApplicantEmptyData(ITestContext context) {


                firstName = " ";
                lastName = " ";
                middleName = " ";
                email = " ";
                phone = " ";
                courseId = " ";
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(applicant);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
       }

        given().
                body(methods.toJsonString(applicant)).
        when().
                post(AllEndpoints.All_Applicants).
        then().
                log().body().
                assertThat().statusCode(400).
                body("error", equalTo("Bad Request"));

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

       given().
                body(jsonString).
       when().
                post(AllEndpoints.All_Applicants).
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

       given().
                body(jsonString).
       when().
                post(AllEndpoints.All_Applicants).
       then().
                log().body().
                assertThat().statusCode(400).
                body("message[0]", equalTo("phone must match /^\\+374[1-9]{1}[0-9]{7}$/ regular expression"));



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

        given().
                body(jsonString).
        when().
                post(AllEndpoints.All_Applicants).
        then().
                assertThat().statusCode(400).
                body("message[0]", equalTo("courseId must be a mongodb id"));

    }


    @Test
    public void getApplicants() {
        given().
        when().
                get(AllEndpoints.All_Applicants).
        then(). log().body().
                assertThat().statusCode(200);

    }

//    public void getValidApplicant(ITestContext context) {
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
    @Test
    public void updateApplicant(ITestContext context) {
        String endpoint = "http://localhost:3000/applicants/6440214e92d008367a0edaca";
        String body = """
                 {
                 "firstName": "Sha",
                 "lastName": "Mi",
                 "middleName": "At",
                 "email": "mirzakhanyanshushan@gmail.com",
                 "phone": "+37498775545",
                 "isWarVeteran": false,
                 "isLessThan16": false,
                 "courseId": "6442a7616cb32f32d7d4f520",
                 "courses": [
                     "string"
                   ],
                   "notes": [
                     "string"
                   ]
                   
                }
                """;
        var response =
                given().
                        body(body).
                        when().
                        patch(endpoint).
                        then();

    }


    @Test
    public void deleteApplicantAuth(ITestContext context) {
        String applicantId = (String) context.getAttribute("applicantId");
        String endpoint = "http://localhost:3000/applicants/{applicantId}";
        var response =
                given().
                        pathParam("applicantId", applicantId).
                        when().
                        delete(endpoint).
                        then();
        response.log().body();


   }
}



