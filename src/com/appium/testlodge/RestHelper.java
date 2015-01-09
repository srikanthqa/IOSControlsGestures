//package slyde.automation.utils;
//
//import com.jayway.restassured.http.ContentType;
//import com.jayway.restassured.response.Response;
//import com.jayway.restassured.specification.RequestSpecification;
//import org.codehaus.jackson.JsonParseException;
//import org.codehaus.jackson.annotate.JsonProperty;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Random;
//
//import static com.jayway.restassured.RestAssured.given;
//
///**
// * Created by srikanthvejendla on 9/12/14.
// */
//public class RestHelper {
//
//    public static WebDriver driver;
//    public static String AppURL;
//    private static final Integer ProjectID = 7912;
//    private static final Integer TestPlanID = 8733;
//    private static final Integer WebConsumer_TestSuiteID = 27879;
//    public static Integer getTestCaseID(String TestCaseName) {
//        Response response = given()
//                .contentType(ContentType.URLENC)
//                .auth()
//                .basic("commerceqateam@skplanetinc.com", "skplanet")
//                .expect()
//                .statusCode(200)
//                .get("https://skplanetinc.api.testlodge.com/v1/projects/" + ProjectID + "/runs/" + RunnerTest.TestRunID + "/executed_steps.json");
//        Integer tpages = response.getBody().path("pagination.total_pages");
//        ArrayList<Integer> tcid = new ArrayList<Integer>();
//        ArrayList<String> tcname = new ArrayList<String>();
//        for (int i = 1; i <= tpages; i++) {
//            Response response1 = given()
//                    .contentType(ContentType.URLENC)
//                    .auth()
//                    .basic("commerceqateam@skplanetinc.com", "skplanet")
//                    .expect()
//                    .statusCode(200)
//                    .get("https://skplanetinc.api.testlodge.com/v1/projects/" + ProjectID + "/runs/" + RunnerTest.TestRunID + "/executed_steps.json?page="
//                            + i);
//            ArrayList<Integer> temp_tid = response1.getBody().path(
//                    "executed_steps.id");
//            ArrayList<String> temp_tname = response1.getBody().path(
//                    "executed_steps.step_number");
//            tcid.addAll(temp_tid);
//            tcname.addAll(temp_tname);
//        }
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        for (int j = 0; j < tcid.size(); j++) {
//            map.put(tcname.get(j), tcid.get(j));
//        }
//        return map.get(TestCaseName);
//    }
//
//    public static void setTestCaseStatus(String TestCaseName, String TestResult) {
//        RequestSpecification request = null;
//        if (TestResult.equals("passed")) {
//            request = given()
//                    .contentType(ContentType.URLENC)
//                    .with()
//                    .parameters("executed_step[actual_result]",
//                            "Passed[Automation]", "executed_step[passed]", "1");
//        } else if (TestResult.equals("failed")) {
//            request = given()
//                    .contentType(ContentType.URLENC)
//                    .with()
//                    .parameters("executed_step[actual_result]",
//                            "Failed[Automation]", "executed_step[passed]", "0");
//        }
//        Integer testcase_id = getTestCaseID(TestCaseName);
//        given(request)
//                .auth()
//                .basic("commerceqateam@skplanetinc.com", "skplanet")
//                .expect()
//                .statusCode(200)
//                .patch("https://skplanetinc.api.testlodge.com/v1/projects/" + ProjectID + "/runs/" + RunnerTest.TestRunID + "/executed_steps/"
//                        + testcase_id + ".json");
//
//    }
//
//
//    public static Integer createTestRun() {
//        RequestSpecification request1 = given()
//                .contentType(ContentType.URLENC)
//                .with()
//                .parameters("run[name]", generateTestRunName(), "run[plan_id]",
//                        TestPlanID, "run[suite_ids][]", WebConsumer_TestSuiteID);
//        Response resp = given(request1)
//                .auth()
//                .basic("commerceqateam@skplanetinc.com", "skplanet")
//                .expect()
//                .statusCode(201)
//                .post("https://skplanetinc.api.testlodge.com/v1/projects/"
//                        + ProjectID + "/runs.json");
//        return resp.getBody().path("id");
//    }
//
//    @SuppressWarnings("deprecation")
//    public static String generateTestRunName() {
//        Date date = new Date();
//        StringBuilder testrunname = new StringBuilder();
//        testrunname.append(System.getProperty("browserType"));
//        testrunname.append(System.getProperty("browserVersion"));
//        testrunname.append("_");
//        testrunname.append(System.getProperty("osPlatform"));
//        testrunname.append("_");
//        testrunname.append(System.getProperty("qaEnvironment"));
//        testrunname.append("_");
//        testrunname.append(date.getMonth()+1);
//        testrunname.append(date.getDate());
//        testrunname.append(date.getYear() + 1900);
//        return "Slyde-Web-Consumer-Automation-"+ testrunname;
//    }
//
//    private String Consumer_SKPAuthorizationKey;
//
//    public Consumer ConsumerRegisterRequest(){
//        String EmailAddress="srikanth.vejendla+skp-no-email-"+generateString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",14)+"@skplanetinc.com";
//        String Password="skplanet";
//        String json=String.format("{\"email\": {\"address\": \"%s\" },\"password\": \"%s\",\"firstName\": \"Srikanth\",\"lastName\": \"Vejendla\",\"mobile\": \"0123456789\",\"device\": {\"uuid\": \"dsghgfhdgfhgdfhgdhg\",\"platformType\": \"PLATFORM_TYPE_IOS\",\"publicKey\": \"fgdfgjhdfjhfjhd\",\"notificationId\": \"efghsdfgdhgdfhgdhdghdg\"}}",EmailAddress,Password);
//        Consumer consumer= null;
//        try {
//            consumer = new ObjectMapper().readValue(json,Consumer.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String env = System.getProperty("qaEnvironment");
//        if (env.equals("Dev01")) {
//            Response response=given().contentType(ContentType.JSON).with().body(json).expect().statusCode(200).when().post(SettingsHelper.Dev01+":9000/v2/consumers/users/register");
//            Consumer_SKPAuthorizationKey=response.getHeader("X-Skp-Authorization");
//        } else if (env.equals("Dev02")) {
//            Response response=given().contentType(ContentType.JSON).with().body(json).expect().statusCode(200).when().post(SettingsHelper.Dev02+":9000/v2/consumers/users/register");
//            Consumer_SKPAuthorizationKey=response.getHeader("X-Skp-Authorization");
//
//        } else if (env.equals("Staging")) {
//            Response response=given().contentType(ContentType.JSON).with().body(json).expect().statusCode(200).when().post(SettingsHelper.Staging_rest+"/consumers/users/register");
//            Consumer_SKPAuthorizationKey=response.getHeader("X-Skp-Authorization");
//
//        } else if (env.equals("Prod")) {
//            Response response=given().contentType(ContentType.JSON).with().body(json).expect().statusCode(200).when().post(SettingsHelper.Prod+":9000/v2/consumers/users/register");
//            Consumer_SKPAuthorizationKey=response.getHeader("X-Skp-Authorization");
//
//        }else {
//            Response response=given().contentType(ContentType.JSON).with().body(json).expect().statusCode(200).when().post(SettingsHelper.Dev02+":9000/v2/consumers/users/register");
//            Consumer_SKPAuthorizationKey=response.getHeader("X-Skp-Authorization");
//
//        }
//             return consumer;
//    }
//
//    public String ConsumerAuthorizationKey() throws JsonParseException, JsonMappingException, IOException{
//        if(Consumer_SKPAuthorizationKey==null){
//            ConsumerRegisterRequest();
//        }
//        return Consumer_SKPAuthorizationKey;
//    }
//
//
//    public static class Consumer{
//        public email email;
//        public static class email{
//            @JsonProperty("address")
//            private String address;
//            public String getEmail(){
//                return address;
//            }
//
//            public void setEmail(String address){
//                this.address=address;
//            }
//        }
//        @JsonProperty("password")
//        private String password;
//        public String getPassword(){
//            return password;
//        }
//
//        public void setPassword(String password){
//            this.password=password;
//        }
//        @JsonProperty("firstName")
//        private String firstName;
//        public String getFirstname(){
//            return firstName;
//        }
//
//        public void setFirstname(String firstname){
//            this.firstName=firstname;
//        }
//        @JsonProperty("lastName")
//        private String lastName;
//        public String getLastname(){
//            return lastName;
//        }
//
//        public void setLastname(String lastname){
//            this.lastName=lastname;
//        }
//        @JsonProperty("mobile")
//        private long mobile;
//        public long getMobileNo(){
//            return mobile;
//        }
//
//        public void setMobileNo(long mobile){
//            this.mobile=mobile;
//        }
//        public device device;
//        public static class device{
//            @JsonProperty("uuid")
//            private String uuid;
//            public String getUUID(){
//                return uuid;
//            }
//
//            public void setUUID(String uuid){
//                this.uuid=uuid;
//            }
//            @JsonProperty("platformtype")
//            private String platformtype;
//            public String getPlatformType(){
//                return platformtype;
//            }
//
//            public void setPlatformType(String platformtype){
//                this.platformtype=platformtype;
//            }
//            @JsonProperty("publickey")
//            private String publickey;
//            public String getPublicKey(){
//                return publickey;
//            }
//
//            public void setPublicKey(String publickey){
//                this.publickey=publickey;
//            }
//            @JsonProperty("notificationId")
//            private String notificationId;
//            public String getNotificationID(){
//                return notificationId;
//            }
//
//            public void setNotificationID(String notificationid){
//                this.notificationId=notificationid;
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "Consumer [email=" + email.address + ", password=" + password + ", firstName=" + firstName + ", lastname="
//                    + lastName + ", mobileno=" + mobile + " , uuid=" + device.uuid + " , platformtype=" + device.platformtype + " , publickey=" + device.publickey + " , notificationid=" + device.notificationId + "]";
//        }
//
//
//    }
//
//    public static String generateString(String characters, int length)
//    {
//        Random rng = new Random(System.nanoTime());
//        char[] text = new char[length];
//        for (int i = 0; i < length; i++)
//        {
//            text[i] = characters.charAt(rng.nextInt(characters.length()));
//        }
//        return new String(text);
//    }
//
//    public static void isTextPresent(String text) {
//        driver.findElement(By.xpath("//*[contains(.,'" + text + "')]"));
//    }
//
//    public static void isTextNotPresent(String text) {
//        boolean found = true;
//        try {
//            driver.findElement(By.xpath("//*[contains(.,'" + text + "')]"));
//        } catch (Exception e) {
//            found = false;
//        } finally {
//            Assert.assertFalse(found);
//        }
//    }
//
//    public static void sleep(int d) {
//        try {
//            Thread.currentThread();
//            Thread.sleep(d * 1000);
//        } catch (InterruptedException ie) {
//        }
//    }
//
//}
