import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class izaanLogin {
    @Test
    void login(){
        RestAssured.baseURI="https://v57pmk39lf.execute-api.us-east-1.amazonaws.com";
        RequestSpecification postcredentials=RestAssured.given();

        JSONObject requestParams=new JSONObject();
        requestParams.put("username","humavahora91");
        requestParams.put("password","adsgjsd");

        postcredentials.header("Authorization","Basic aHVtYXZhaG9yYTkxOkl6YWFuQGh1bWF2YWhvcmE5MUAxMjM=");
        postcredentials.header("Content-Type","application/json");
        postcredentials.body(requestParams.toJSONString());



        Response response=postcredentials.request(Method.POST,"//prod/user-auth");
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);
        int statuscode=response.getStatusCode();
        System.out.println(statuscode);
    }
}
