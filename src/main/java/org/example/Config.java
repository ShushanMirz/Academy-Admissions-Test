package org.example;

import java.util.HashMap;
import java.util.Map;

public class Config {

    String baseEndpoint = "http://localhost:3000";
    String applicantEnd = baseEndpoint + "/applicants";
    String userEnd = baseEndpoint + "/users";
    String courseEnd = baseEndpoint + "/courses";

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
}
