package support;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestWrapperFinal {

    private String baseUrl = "https://skryabin.com/recruit/api/v1/";

    private static String loginToken;
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public void login (Map <String, String> login) {

        HashMap loginAsRecruiter = new HashMap();
        loginAsRecruiter.put("email","owen@example.com");
        loginAsRecruiter.put("password", "welcome");

     /*
       String login = "{" +
                "   \"email\": \"owen@example.com\"," +
                "   \"password\": \"welcome\"} ";   */
        //prepare
        RequestSpecification request = RestAssured.
                given().
                        log().all().
                        baseUri(baseUrl).
                        header(CONTENT_TYPE, JSON).
                        body(login);
        //execute
     Response response =  request.
                        when().
                        post( "login");
       // verify and extract
     Map <String, Object> result = response.
                        then().
                        log().all().
                        statusCode(200).
                        extract().
                        jsonPath().
                        getMap("");

        loginToken = "Bearer " + result.get("token");
    }

    public void createPosition( Map<String, String> credentials ){

        HashMap data = new HashMap();
        data.put("title","Automation");
        data.put("description", "Automation");
        data.put("address","4970 El Camino Real");
        data.put("state", "CA");
        data.put("zip", "94022");
        data.put("dateOpen", "12/31/2019");
/*
        String dateOpen = position.get("dateOpen");
        String isoDateOpen = new SimpleDateFormat("yyyy-MM-dd").format(new Date(dateOpen));
        position.put("dateOpen", isoDateOpen);

        String title = position.get("title");
        String uniqueTitle = title + new SimpleDateFormat("-yyyy-MM-dd-HH-mm-sss").format(new Date());*/

       /*  String position = "{" +
                "   \"title\": \"Automation\"," +
                "   \"description\": \"Automation test\"," +
                "   \"address\": \"4970 El Camino Real\"," +
                "   \"state\": \"CA\"," +
                "   \"zip\": \"94022\"," +
                "   \"dateOpen\": \"12/31/2019\"} ";   */
         //prepare
        RequestSpecification request = RestAssured.

                 given().
                 log().all().
                 baseUri(baseUrl).
                 header(CONTENT_TYPE, JSON).
                 header(AUTH,loginToken).
                 body(data);

        Response response = request.
                 when().
                 post("positions");

        Map<String, Object> result = response.

                 then().
                 log().all().
                 statusCode(201).
                 extract().
                 jsonPath().
                getMap("");

      /*  lastPosition = result;
        assertMetadata(result, "positions");
        return result;*/




    }
}




