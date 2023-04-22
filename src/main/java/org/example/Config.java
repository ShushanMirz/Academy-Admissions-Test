package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class Config {

    String baseEndpoint = "http://localhost:3000";
    String applicantEnd = baseEndpoint + "/applicants";
    String userEnd = baseEndpoint + "/users";
    String courseEnd = baseEndpoint + "/courses";

    String testEnd = baseEndpoint + "/tests";

    String eventEnd = baseEndpoint + "/events";


    public static Map<String,String> header(String token) {
        return  new HashMap<>() {{
            put("content type","");
            put("Authorization","Bearer " + token);
        }};

    }


    public String getBaseEndpoint() {
        return baseEndpoint;
    }

    public void setBaseEndpoint(String baseEndpoint) {
        this.baseEndpoint = baseEndpoint;
    }

    public String getApplicantEnd() {
        return applicantEnd;
    }

    public void setApplicantEnd(String applicantEnd) {
        this.applicantEnd = applicantEnd;
    }

    public String getUserEnd() {
        return userEnd;
    }

    public void setUserEnd(String userEnd) {
        this.userEnd = userEnd;
    }

    public String getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(String courseEnd) {
        this.courseEnd = courseEnd;
    }


    @BeforeClass
    public static void setup () {
        RestAssured.baseURI = "http://localhost:3000";
        //RestAssured.basePath = "/applicants";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

//        RestAssured.responseSpecification = new ResponseSpecBuilder()
//                .expectStatusCode(201)
//                .build();
    }
}
