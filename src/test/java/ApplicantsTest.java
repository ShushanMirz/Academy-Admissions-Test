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
    Applicant applicant;
    Methods methods = new Methods();

    @BeforeMethod
    public void setToken (Method methodName) {
        //should write a logic for authorization,

    }

    @BeforeMethod
    public void initData(Method methodName) {

        firstName = random.getRndName();
        lastName = random.getRndName();
        middleName =  random.getRndName();
        email = random.getRndEmail();
        phone = "+374" + random.getRunPhoneValid();
        isWarVeteran = random.getRndBool();
        isLessThan16 = random.getRndBool();
        courseId = "6449527033002ff8a701ede1";

        applicant = new Applicant(
                firstName,
                lastName,
                middleName,
                email,
                phone,
                isWarVeteran,
                isLessThan16,
                courseId
        );
    }

    @BeforeMethod
     public void getApplicants (Method method, ITestContext context) {

        if (method.getName().contains("ID"))  {
           String applicantId =

            given().
                    body(methods.toJsonString(applicant)).
            when().
                    get(AllEndpoints.All_Applicants).
            then()
                    .log()
                    .all()
                    .extract()
                    .jsonPath().get("message");
           //should write method which takes an id from getAllApplicants

        context.setAttribute("applicantId", applicantId);
        System.out.println(applicantId);

        }

    }



    @Test
    public void verifyCreateApplicant() {

                given().
                        body(methods.toJsonString(applicant)).

                when().
                        post(AllEndpoints.All_Applicants).
                then().
                        assertThat().statusCode(201).
                        body("message", equalTo("Applicant successfully registered."));
    }

    @Test
    public void verifyCreateApplicantEmptyData() {

        applicant.setFirstName(" ");
        applicant.setLastName(" ");
        applicant.setMiddleName(" ");
        applicant.setEmail(" ");
        applicant.setPhone(" ");
        applicant.setLessThan16(false);
        applicant.setWarVeteran(false);
        applicant.setCourseId(" ");

                given().
                        body(methods.toJsonString(applicant)).
                when().
                        post(AllEndpoints.All_Applicants).
                then().
                        assertThat().statusCode(400).
                        body("error", equalTo("Bad Request"));

    }

    @Test
    public void verifyCreateApplicantEmailNotValid() {

      applicant.setEmail(random.getRndName());

                given().
                        body(methods.toJsonString(applicant)).
                when().
                        post(AllEndpoints.All_Applicants).
                then().
                        assertThat().statusCode(400).
                        body("message[0]", equalTo("email must be an email"));

    }

    @Test
    public void verifyCreateApplicantPhoneNotValid() {

      applicant.setPhone(random.getRndWrongNum());

                given().
                        body(methods.toJsonString(applicant)).
                when().
                        post(AllEndpoints.All_Applicants).
                then().
                        log().body().
                        assertThat().statusCode(400).
                        body("message[0]", equalTo("phone must match /^\\+374[1-9]{1}[0-9]{7}$/ regular expression"));

    }

    @Test
    public void verifyCreateApplicantCourseNotFound() {

        applicant.setCourseId(random.getRndId());

                given().
                        body(methods.toJsonString(applicant)).
                when().
                        post(AllEndpoints.All_Applicants).
                then().
                        assertThat().statusCode(400).
                        body("message[0]", equalTo("courseId must be a mongodb id"));

    }


    @Test
    public void getApplicantsAuth() {

                given().

                when().
                       get(AllEndpoints.All_Applicants).
                then().
                       assertThat().statusCode(200);

            //what should I assert

    }


    @Test
    public void getValidApplicantIDAuth (ITestContext context) {

        //should take active applicant id

        String applicantId = (String) context.getAttribute("applicantId");

                given().
                        pathParam("applicantId", applicantId).
                when().
                        get(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(200).
                        body("message", equalTo("You have successfully received the Applicant."));
        // what should I assert
    }

    @Test
    public void VerifyGetApplicantIDUnauthorized(ITestContext context) {

        //should take valid id

        String applicantId = (String) context.getAttribute("applicantId");

                given().
                        pathParam("applicantId", applicantId).
                when().
                        get(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(401).
                        body("message", equalTo("Unauthorized"));

    }
    @Test
    public void VerifyGetApplicantIDNotFoundAuth(ITestContext context) {

        String applicantId = random.getRndId();

                given().
                        pathParam("applicantId", applicantId).
                when().
                        get(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(404).
                        body("message", equalTo("Applicant is not found."));
    }


    @Test
    public void updateApplicantIDAuth(ITestContext context) {

        //take valid id of applicant
        String applicantId = (String) context.getAttribute("applicantId");

               given().
                       pathParam("applicantId", applicantId).
                       body(methods.toJsonString(applicant)).
               when().
                       patch(AllEndpoints.Single_Applicant).
               then().
                       assertThat().statusCode(200).
                       body("message", equalTo("Applicant has been successfully updated."));

                //should assert that all data successfully updated

    }


    @Test
    public void updateApplicantIDAUnauthorized(ITestContext context) {

        //take valid id of applicant
        String applicantId = (String) context.getAttribute("applicantId");

                given().
                        pathParam("applicantId", applicantId).
                        body(methods.toJsonString(applicant)).
                when().
                        patch(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(401).
                        body("message", equalTo("Unauthorized"));

    }

    @Test
    public void updateArchivedApplicantIDAuth(ITestContext context) {

        //take valid id of archived applicant
        String applicantId = (String) context.getAttribute("applicantId");

                given().
                        pathParam("applicantId", applicantId).
                        body(methods.toJsonString(applicant)).
                when().
                        patch(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(403).
                        body("message", equalTo("Applicant is archived"));

    }
    @Test
    public void updateApplicantIDNotFoundAuth(ITestContext context) {


        String applicantId = random.getRndId();
        applicant.setCourseId(" valid course id on which this applicant is not enrolled");

                given().
                        pathParam("applicantId", applicantId).
                        body(methods.toJsonString(applicant)).
                when().
                        patch(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(404).
                        body("message", equalTo("The applicant is not enrolled in this course."));



    }

    @Test
    public void updateApplicantIDNotEnrolledCourseAuth(ITestContext context) {

        //take valid id of  applicant

        String applicantId = (String) context.getAttribute("applicantId");


                 given().
                         pathParam("applicantId", applicantId).
                         body(methods.toJsonString(applicant)).
                 when().
                         patch(AllEndpoints.Single_Applicant).
                 then().
                         assertThat().statusCode(404).
                         body("message", equalTo("Applicant is not found."));



    }

    @Test
    public void VerifyDeleteApplicantIDAuth(ITestContext context) {

        String applicantId = (String) context.getAttribute("applicantId");

                  given().
                          pathParam("applicantId", applicantId).
                  when().
                          delete(AllEndpoints.Single_Applicant).
                  then().
                          assertThat().statusCode(200).
                          body("message", equalTo("Applicant successfully archived."));

   }

    @Test
    public void VerifyDeleteApplicantIDNotFoundAuth(ITestContext context) {

        String applicantId = random.getRndId();

                 given().
                            pathParam("applicantId", applicantId).
                 when().
                            delete(AllEndpoints.Single_Applicant).
                 then().
                            assertThat().statusCode(404).
                            body("message", equalTo("Applicant is not found."));

    }

    @Test
    public void VerifyDeleteApplicantIDUnauthorized(ITestContext context) {

        String applicantId = (String) context.getAttribute("applicantId");

                given().
                        pathParam("applicantId", applicantId).
                when().
                        delete(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(401).
                        body("message", equalTo("Unauthorized"));

    }

    @Test
    public void VerifyDeleteAlreadyArchivedApplicantIDAuth(ITestContext context) {

        //Should take already archived applicant id
        String applicantId = (String) context.getAttribute("applicantId");

                given().
                        pathParam("applicantId", applicantId).
                when().
                        delete(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(409).
                        body("message", equalTo("Applicant is already archived"));

    }

    @Test
    public void VerifyRestoreApplicantIDAuth(ITestContext context) {

        //Should take already archived applicant id
        String applicantId = (String) context.getAttribute("applicantId");

                given().
                        pathParam("applicantId", applicantId).
                when().
                        put(AllEndpoints.Single_Applicant).
                then().
                        assertThat().statusCode(200).
                        body("message", equalTo("Applicant successfully restored."));

    }

    @Test
    public void VerifyRestoreApplicantIDUnauthorized(ITestContext context) {

        //Should take already archived applicant id
        String applicantId = (String) context.getAttribute("applicantId");

            given().
                    pathParam("applicantId", applicantId).
            when().
                    put(AllEndpoints.Single_Applicant).
            then().
                    assertThat().statusCode(401).
                    body("message", equalTo("Unauthorized"));

    }

    @Test
    public void VerifyRestoreDuplicatedApplicantIDAuth(ITestContext context) {

        //Should take already archived applicant id, but new applicant with that email or phone already exist
        String applicantId = (String) context.getAttribute("applicantId");

            given().
                    pathParam("applicantId", applicantId).
            when().
                    put(AllEndpoints.Single_Applicant).
            then().
                    assertThat().statusCode(403).
                    body("message", equalTo("Applicant with that email or phone already exists"));

    }

    @Test
    public void VerifyRestoreApplicantIDNotFoundAuth(ITestContext context) {

        String applicantId = random.getRndId();

            given().
                    pathParam("applicantId", applicantId).
            when().
                    delete(AllEndpoints.Single_Applicant).
            then().
                    assertThat().statusCode(404).
                    body("message", equalTo("Applicant is not found."));

    }

    @Test
    public void VerifyRestoreActiveApplicantIDAuth(ITestContext context) {

        //Should take active applicant id
        String applicantId = (String) context.getAttribute("applicantId");

            given().
                    pathParam("applicantId", applicantId).
            when().
                    put(AllEndpoints.Single_Applicant).
            then().
                    assertThat().statusCode(409).
                    body("message", equalTo("Applicant is not archived"));

    }


}



