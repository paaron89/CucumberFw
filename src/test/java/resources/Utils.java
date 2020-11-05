package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification reqAddplace;

    public RequestSpecification requestSpecification() throws IOException {

        if(reqAddplace == null){

        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        reqAddplace = new RequestSpecBuilder().setBaseUri(getGolbalValue("baseUrl"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return reqAddplace;
        }
        return reqAddplace;
    }

    public static String getGolbalValue(String propertyKey) throws IOException {
        Properties prop = new Properties();
        FileInputStream propfile = new FileInputStream("src/test/java/resources/golbal.properties");
        prop.load(propfile);
        return prop.getProperty(propertyKey);
    }
}
