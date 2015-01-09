package com.appium.testlodge;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;


public class RunTestCase {
	
//	String ProjectID="10019";
//	
//	public static void main(String[] args) {
//		//https://shopkick.api.testlodge.com/v1/projects/10019/runs/124735/executed_steps/47813.json
//		String TestResult="passed";
//		RequestSpecification request = null;
//      if (TestResult.equals("passed")) {
//          request = given()
//                  .contentType(ContentType.URLENC)
//                  .with()
//                  .parameters("executed_step[actual_result]",
//                          "Passed[Automation]", "executed_step[passed]", "1");
//      } else if (TestResult.equals("failed")) {
//          request = given()
//                  .contentType(ContentType.URLENC)
//                  .with()
//                  .parameters("executed_step[actual_result]",
//                          "Failed[Automation]", "executed_step[passed]", "0");
//      }
//      //Integer testcase_id = getTestCaseID(TestCaseName);
//      //System.out.println(getTestCaseID("TC01"));
//      given(request)
//              .auth()
//              .basic("mark@shopkick.com", "sktest123")
//              .expect()
//              .statusCode(200)
//              .patch("https://shopkick.api.testlodge.com/v1/projects/10019/runs/124735/executed_steps/6461210.json");
//	}

	public static void main(String[] args) {
		setTestCaseStatus("TC01","passed");
	}
	
	public static Integer getTestCaseID(String TestCaseName) {
      Response response = given()
              .contentType(ContentType.URLENC)
              .auth()
              .basic("mark@shopkick.com", "sktest123")
              .expect()
              .statusCode(200)
              .get("https://shopkick.api.testlodge.com/v1/projects/10019/runs/124737/executed_steps.json");
      Integer tpages = response.getBody().path("pagination.total_pages");
      ArrayList<Integer> tcid = new ArrayList<Integer>();
      ArrayList<String> tcname = new ArrayList<String>();
      for (int i = 1; i <= tpages; i++) {
          Response response1 = given()
                  .contentType(ContentType.URLENC)
                  .auth()
                  .basic("mark@shopkick.com", "sktest123")
                  .expect()
                  .statusCode(200)
                  .get("https://shopkick.api.testlodge.com/v1/projects/10019/runs/124737/executed_steps.json?page="
                          + i);
          ArrayList<Integer> temp_tid = response1.getBody().path(
                  "executed_steps.id");
          ArrayList<String> temp_tname = response1.getBody().path(
                  "executed_steps.step_number");
          tcid.addAll(temp_tid);
          tcname.addAll(temp_tname);
      }
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      for (int j = 0; j < tcid.size(); j++) {
          map.put(tcname.get(j), tcid.get(j));
      }
      return map.get(TestCaseName);
  }
	
  public static void setTestCaseStatus(String TestCaseName, String TestResult) {
  RequestSpecification request = null;
  if (TestResult.equals("passed")) {
      request = given()
              .contentType(ContentType.URLENC)
              .with()
              .parameters("executed_step[actual_result]",
                      "Passed[Automation]", "executed_step[passed]", "1");
  } else if (TestResult.equals("failed")) {
      request = given()
              .contentType(ContentType.URLENC)
              .with()
              .parameters("executed_step[actual_result]",
                      "Failed[Automation]", "executed_step[passed]", "0");
  }
  Integer testcase_id = getTestCaseID(TestCaseName);
  given(request)
          .auth()
          .basic("mark@shopkick.com", "sktest123")
          .expect()
          .statusCode(200)
          .patch("https://shopkick.api.testlodge.com/v1/projects/10019/runs/124737/executed_steps/"
                  + testcase_id + ".json");

}

}
