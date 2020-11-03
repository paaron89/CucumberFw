package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlace;
import pojo.Location;
import utilities.RawToJson;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddPlaceSteps {
    RequestSpecification reqSpecPostPlace;
    ResponseSpecification responseSpecPostPlace;
    Response responsePostPlace;


    @Given("Add place payload")
    public void add_place_payload() {
        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress("Macskakő utca 4.");
        addPlace.setLanguage("HUN");
        addPlace.setPhone_number("0620777189666");
        addPlace.setWebsite("valami.com");
        addPlace.setName("Náme");
        List<String> myList = new ArrayList<String>();
        myList.add("type1");
        myList.add("shop");
        addPlace.setTypes(myList);
        Location location = new Location();
        location.setLat(-38.999999);
        location.setLng(33.424255);
        addPlace.setLocation(location);


        RequestSpecification reqAddplace = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();
//         responseSpecPostPlace = new ResponseSpecBuilder().expectStatusCode(200)
//                .expectContentType(ContentType.JSON);
         reqSpecPostPlace = given().spec(reqAddplace).body(addPlace);

    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_POST_http_request(String string) {
         responsePostPlace = (Response) reqSpecPostPlace.when().post("/maps/api/place/add/json");

    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer expectedCode) {
        Assert.assertEquals(responsePostPlace.statusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {

        String resPostPlaceString = responsePostPlace.then().extract().asString();
        System.out.println("My response: " + resPostPlaceString);
        JsonPath js = RawToJson.rawToJson(resPostPlaceString);
        Assert.assertEquals(js.getString(keyValue), expectedValue);

    }
}
