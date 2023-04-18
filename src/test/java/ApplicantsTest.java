import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.example.Applicant;
import org.testng.ITestContext;
import org.testng.annotations.*;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApplicantsTest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private boolean isWarVeteran;
    private boolean isLessThan16;
    private String courseId;

    @BeforeMethod
    public void initData() {
        firstName = "Shushan";
        lastName = "Mirzakhanyan";
        middleName = "Atom";
        email = "mirzakhanyanshushan@gmail.com";
        phone = "+37498775545";
        isWarVeteran = true;
        isLessThan16 = true;
        courseId = "6432e0b3727a4414200ffbad";

    }

    @Test
    public void createApplicant(ITestContext context) {
        String endpoint = "http://localhost:3000/applicants";


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

        String applicantId = RestAssured.given().
                header("Content-Type", "application/json").
                body(jsonString).
                when().
                post(endpoint).
                then().log()
                .all()
                .extract()
                .jsonPath()
                .get("id");
        context.setAttribute("applicantId", applicantId);

    }


    @Test
    public void getApplicants() {
        String endpoint = "http://localhost:3000/applicants";
        given().
                // queryParam("id", "64329ea0727a4414200ffb88").
                        when().
                get(endpoint).
                then().
                assertThat().statusCode(200);

    }


    @AfterMethod


    public void getApplicant(ITestContext context) {

        String applicantId = (String) context.getAttribute("applicantId");
        System.out.println(applicantId);
        String endpoint = "http://localhost:3000/applicants/{applicantId}";

        given().
                pathParam("applicantId", applicantId).

                when().
                get(endpoint).
                then();
    }


    @AfterMethod
    public void updateApplicant(ITestContext context) {
        String applicantId = (String) context.getAttribute("applicantId");
        String endpoint = "http://localhost:3000/users/{applicantId}";
        String body = """
                 {
                 "firstName": "Shush",
                 "lastName": "Mirzakhan",
                 "middleName": "Atom",
                 "email": "mirzakhanyanshushan@gmail.com",
                 "phone": "+37498775544",
                 "isWarVeteran": true,
                 "isLessThan16": true
                }
                """;
        var response =
                given().
                        pathParam("applicantId", applicantId).
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        patch(endpoint).
                        then();

    }


    @AfterMethod
    public void deleteApplicant(ITestContext context) {
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



