package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RawToJson {

    public static String getKeyFromJsonAsString(Response response, String key){
        String resp = response.then().extract().asString();
        System.out.println("MY response: " + resp);
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}

