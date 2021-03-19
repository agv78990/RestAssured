import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class GetRequest {
    @Test
    void getLukeDetails(){
        RestAssured.baseURI="https://swapi.dev/api/";
        RequestSpecification httpget=RestAssured.given();

        Response response= httpget.request(Method.GET,"people/1");
        String responseBody=response.asString();
        System.out.println("response BOdy is:"+ responseBody);

       JsonPath bodyToJson=response.jsonPath();
       String name=bodyToJson.get("name");
        System.out.println(name);


        String height=bodyToJson.get("height");
        System.out.println("the height is "+height);


        String mass=bodyToJson.get("mass");
        System.out.println("the mass is"+ mass);
        Assert.assertEquals(mass,"77");



        int statusCode=response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);

        String statusLine=response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }

    @Test
    void vehicles(){
        RestAssured.baseURI="https://swapi.dev/api/";
        RequestSpecification getinfo=RestAssured.given();

        Response response= getinfo.request(Method.GET,"/vehicles/14");
         String responsebody=response.getBody().asString();
        System.out.println("This is about vehicles "+ responsebody);

        JsonPath bodyToJson=response.jsonPath();
        String model=bodyToJson.get("model");
        System.out.println("this is the vehicle model  "+ model);
        String name=bodyToJson.get("name");
        System.out.println(name);
        System.out.println(bodyToJson);


    }
    @Test
    void planets(){
        RestAssured.baseURI="https://swapi.dev/api/";
        RequestSpecification httpGet=RestAssured.given();
        Response response= httpGet.request(Method.GET,"/planets/1/");
        String responseBody= response.getBody().asString();
        System.out.println(responseBody);

        JsonPath bodyToJson=response.jsonPath();
        String diameter=bodyToJson.get("diameter");
        System.out.println(diameter);

        String climate=bodyToJson.get("climate");
        System.out.println("The climate is "+climate);


    }

    @Test
    void films2(){
        RestAssured.baseURI="https://swapi.dev/api/";
        RequestSpecification httpget=RestAssured.given();
        Response response=httpget.request(Method.GET,"/films/2/");
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);
    }


    @Test
    void films1(){
        RestAssured.baseURI="https://swapi.dev/api/";
        RequestSpecification httpGet=RestAssured.given();
        Response response=httpGet.request(Method.GET,"/films/1");
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    void starship(){
        RestAssured.baseURI="https://swapi.dev/api";
        RequestSpecification getInfo=RestAssured.given();
        Response response=getInfo.request(Method.GET,"/starships/9/");
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);
        int statusCode= response.getStatusCode();
        System.out.println(statusCode);
        String statusLine=response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusCode,200);
    }

}
