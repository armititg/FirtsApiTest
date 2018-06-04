import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
//import static io.restassured.RestAssured.when;

//import org.junit.Assert;
//import io.restassured.specification.RequestSpecification;
//import static io.restassured.RestAssured.get;
//import static io.restassured.RestAssured.given;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
//import io.restassured.module.jsv.JsonSchemaValidator.*;

public class NextTest {
    @Test
    public void firstTest() {
        System.out.println("Проверка получения важных комментариев");
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://swapi.co/api/";



        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        //RequestSpecification httpRequest = given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = given().log().all().when().get("people").then().extract().response();
        if(response.statusCode() == 200) {
            String responseBody = response.getBody().asString();
            //request(Method.GET, "/people/?search=Luke Skywalker");
            System.out.println("Response Body is =>  " + responseBody);
        }


        //Response response = given().spec(specification).when().log().all().get("/people/?search=Luke Skywalker").then().statusCode(200).extract().response();
        //Response response = given().spec(specification).when().log().all().get(path).then().statusCode(200).extract().response();
        //Response response = get("/people/?search=Luke Skywalker");//.path("people.name");
        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();



    }
}