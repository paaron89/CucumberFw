package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import resources.ApiResources;
import resources.MapsTestData;
import resources.Utils;
import utilities.RawToJson;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AddPlaceSteps extends Utils {
    RequestSpecification reqSpecPostPlace;
    ResponseSpecification responseSpecPostPlace;
    Response responsePostPlace;
    MapsTestData mapsData = new MapsTestData();


    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
//         responseSpecPostPlace = new ResponseSpecBuilder().expectStatusCode(200)
//                .expectContentType(ContentType.JSON);
         reqSpecPostPlace = given().spec(requestSpecification())
                 .body(mapsData.addPlacePayload(name, language, address));

    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String apiResource, String httpMethod) {
        ApiResources resourceApi = ApiResources.valueOf(apiResource);
        System.out.println(resourceApi);
        if(httpMethod.equalsIgnoreCase("post")){
            responsePostPlace = (Response) reqSpecPostPlace.when().post(resourceApi.getApiResource());
        }
        else if(httpMethod.equalsIgnoreCase("get")){
            responsePostPlace = (Response) reqSpecPostPlace.when().get(resourceApi.getApiResource());
        }

    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer expectedCode) {
        Assert.assertTrue(expectedCode == responsePostPlace.statusCode());
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        Assert.assertEquals(RawToJson.getKeyFromJsonAsString(responsePostPlace, keyValue), expectedValue);

    }

    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String name, String apiResource) throws IOException {
        String placeId = RawToJson.getKeyFromJsonAsString(responsePostPlace,"place_id");
        reqSpecPostPlace = given().spec(requestSpecification()).queryParam("place_id", placeId);
    }

}
