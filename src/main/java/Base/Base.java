package Base;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import java.util.HashMap;
import static io.restassured.RestAssured.*;


public class Base {

    public final static String COMPANY_PAGE_URL = "https://api.eldor.com.tr/pamis/admin/organization/Company";
    public final static String LOGIN_PAGE_URL = "https://api.eldor.com.tr/pamis/identity/v1/Login";

    public static String doPostRequestAuthorizeValidateToken(String endpoint) {

        System.setProperty("javax.net.ssl.trustStore","clientTrustStore.key");
        System.setProperty("javax.net.ssl.trustStorePassword","qwerty");
        RestAssured.useRelaxedHTTPSValidation();

        HashMap map = new HashMap<>();

        map.put("username","akyolg");
        map.put("password","Niso.2022!");
        map.put("applicationId",98);
        System.out.println(map);
        RestAssured.defaultParser = Parser.JSON;
        Response responsetoken =  given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(map).
                when().
                post(endpoint).
                then().
                contentType(ContentType.JSON).extract().response();


        System.out.println(responsetoken);

        String token = responsetoken.jsonPath().getString("accessToken.code");
        System.out.println(token);
        return token;
    }

}
