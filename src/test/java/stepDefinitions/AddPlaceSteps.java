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
import resources.MapsTestData;
import resources.Utils;
import utilities.RawToJson;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddPlaceSteps extends Utils {
    RequestSpecification reqSpecPostPlace;
    ResponseSpecification responseSpecPostPlace;
    Response responsePostPlace;
    MapsTestData mapsData = new MapsTestData();


    @Given("Add place payload")
    public void add_place_payload() {
//         responseSpecPostPlace = new ResponseSpecBuilder().expectStatusCode(200)
//                .expectContentType(ContentType.JSON);
         reqSpecPostPlace = given().spec(requestSpecification()).body(mapsData.addPlacePayload());

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
