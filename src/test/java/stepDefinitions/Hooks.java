package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        String name = "testName";
        MapsSteps step = new MapsSteps();
        if(MapsSteps.placeId==null) {
            step.add_place_payload(name, "testLan", "testAddr");
            step.user_calls_with_http_request("addPlaceAPI", "POST");
            step.verify_place_id_created_maps_to_using(name, "getPlaceAPI");
        }
    }
}
