import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
    static JsonPath js;

    public static void main(String[] args) throws IOException {
        //Validate the response for reqres API
        //Given - Input details to the API
        //When - Send the API request - resource and HTTP method
        //Then - Validate the API response
        //To read payload from external file
        RestAssured.baseURI="https://www.rahulshettyacademy.com";
        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(Files.readAllBytes(Paths.get("/Desktop/addPlace.json"))).
                when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).body("status",equalTo("OK"))
                .header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);

        js = new JsonPath(response);
        String placeId = js.getString("place_id");
        System.out.println(placeId);

        //Update place
        String newAddress = "121 Baker Street,USA";

        given().log().all().queryParam("key","qaclick123").header("Content-type","application/json").
                body("{\n" +
                        "    \"place_id\": \""+placeId+"\",\n" +
                        "    \"address\": \""+newAddress+"\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}").
                when().put("/maps/api/place/update/json?key=qaclick123").then().log().all().statusCode(200).
                body("msg",equalTo("Address successfully updated"));

        //Get Place
        String getPlaceResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId).
                when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).
                extract().response().asString();
         JsonPath js1= ReusableMethods.rawToJson(getPlaceResponse);
         String fetchedAddress = js.getString("address");
        System.out.println("Expected Address:"+newAddress);
        System.out.println("Actual Address:"+fetchedAddress);
        Assert.assertEquals(fetchedAddress,newAddress);








        
    }
}
