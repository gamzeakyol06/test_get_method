package Test;
import Base.Base;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_StatusCode_Test extends Base {

    String token = doPostRequestAuthorizeValidateToken(LOGIN_PAGE_URL);
    @Test
    public void Test_Company() {
        given().headers("Authorization","Bearer "+ token).
                contentType("application/json").
                when().
                get(COMPANY_PAGE_URL + "").
                then().
                statusCode(200).log().all();
    }
}
