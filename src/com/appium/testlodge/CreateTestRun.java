package com.appium.testlodge;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class CreateTestRun {

	
	public static void main(String[] args) {
		//Create Test Run
		//https://shopkick.api.testlodge.com/v1/projects/10019/runs.json
		RequestSpecification request1 = given()
              .contentType(ContentType.URLENC)
              .with()
              .parameters("run[name]", "Appium Test Run 1", "run[plan_id]",
                      "11001", "run[suite_ids][]", "37118");
      Response resp = given(request1)
              .auth()
              .basic("mark@shopkick.com", "sktest123")
              .expect()
              .statusCode(201)
              .post("https://shopkick.api.testlodge.com/v1/projects/10019/runs.json");
      System.out.println(resp.getBody().path("id"));
		
	}
}
