package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;


public class Config {

 public String  jsonToString (Object ob) {

     String jsonString = "";
     ObjectMapper mapper = new ObjectMapper();
     try {
         jsonString = mapper.writeValueAsString(ob);
     } catch (
             JsonProcessingException e) {
         throw new RuntimeException(e);
     }
     return jsonString;
 }


    @BeforeClass
    public static void setup () {
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
