import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test_GET {

    @Test
    void responseBodyCheck(){

        Response response=get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.body());
        System.out.println(response.statusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    void getCheck(){

        given().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
                .body("data.id[0]",equalTo(7));
    }
}
