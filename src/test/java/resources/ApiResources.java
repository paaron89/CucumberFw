package resources;

public enum ApiResources {



    addPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    private String apiResource;

    ApiResources(String apiResource) {
        this.apiResource = apiResource;
    }

    public String getApiResource(){
     return apiResource;
    }
}
