package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class MapsTestData {

    public AddPlace addPlacePayload(String name, String language, String address){

        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress(address);
        addPlace.setLanguage(language);
        addPlace.setPhone_number("0620777189666");
        addPlace.setWebsite("valami.com");
        addPlace.setName(name);
        List<String> myList = new ArrayList<String>();
        myList.add("type1");
        myList.add("shop");
        addPlace.setTypes(myList);
        Location location = new Location();
        location.setLat(-38.999999);
        location.setLng(33.424255);
        addPlace.setLocation(location);
        return addPlace;
    }

}
