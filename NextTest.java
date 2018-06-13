//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.jayway.jsonpath.Predicate;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NextTest {
    public NextTest() {
    }

    @BeforeAll
    static void initAll() {
        RestAssured.baseURI = "https://swapi.co/api/";
        String BaseURL = "https://swapi.co/api/";
    }

    @Test
    public void HowMuchFilms() {
        int CountFilms = (new JsonPath(((Response)((ValidatableResponse)((Response)RestAssured.given().expect().statusCode(200).when().get("films", new Object[0])).then()).extract().response()).asString())).getInt("count");
        System.out.println("There ara " + CountFilms + " films about world Star Wars.");
    }

    @Test
    public void HowMuchPerson() {
        int CountPerson = (new JsonPath(((Response)((ValidatableResponse)((Response)RestAssured.given().expect().statusCode(200).when().get("people", new Object[0])).then()).extract().response()).asString())).getInt("count");
        if (CountPerson >= 100) {
            System.out.println("There ara more 100 person in films about world Star Wars.");
        } else {
            System.out.println("There ara " + CountPerson + " person in films about world Star Wars.");
        }

    }

    @Test
    public void Episod_Four() {
        String GetAllFilms = ((Response)((ValidatableResponse)((Response)RestAssured.given().expect().statusCode(200).when().get("films/", new Object[0])).then()).extract().response()).body().asString();
        String FindFilm = com.jayway.jsonpath.JsonPath.read(GetAllFilms, "$..[?(@.episode_id == 4)]", new Predicate[0]).toString();
        String Title = (new JsonPath(FindFilm)).getString("title");
        System.out.println("The episod 4 were name: " + Title);
        System.out.println("It is relesed at: " + (new JsonPath(FindFilm)).getString("release_date"));
        System.out.println("The producers were: " + (new JsonPath(FindFilm)).getString("producer"));
    }

    @Test
    public void PlanetNamesInTwoEpisode() {
        String GetAllFilms = ((Response)((ValidatableResponse)((Response)RestAssured.given().expect().statusCode(200).when().get("films", new Object[0])).then()).extract().response()).body().asString();
        String FindFilm = com.jayway.jsonpath.JsonPath.read(GetAllFilms, "$..[?(@.episode_id == 2)]", new Predicate[0]).toString();
        System.out.println("The episod 2 were name: " + (new JsonPath(FindFilm)).getString("planets"));
    }

    @Test
    public void Luke_Skywalker() {
        Response response = (Response)((ValidatableResponse)((Response)RestAssured.given().when().get("/people/?search=Luke Skywalker", new Object[0])).then()).extract().response();
        if (response.statusCode() == 200) {
            String responseBody = response.getBody().asString();
            System.out.println("Response Body is =>  " + responseBody);
            JsonPath JsonPath = new JsonPath(responseBody);
            String HomeWorls = JsonPath.getString("results.homeworld");
            String HomeWorl_001 = HomeWorls.substring(21, HomeWorls.length() - 1);
            System.out.println("String " + HomeWorl_001);
            String response_01 = ((Response)((ValidatableResponse)((Response)RestAssured.given().get(HomeWorl_001, new Object[0])).then()).extract().response()).getBody().asString();
            JsonPath LuckHome = new JsonPath(response_01);
            String LuckHome_01 = LuckHome.getString("name");
            System.out.println("His home is " + LuckHome_01);
        }

    }
}
