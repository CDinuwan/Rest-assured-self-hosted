import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class SelfHostedTest {

    @Test
    public void test_get(){

        baseURI="http://localhost:3000/";
        given().
                param("name","Automation").
                get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_post(){

        JSONObject request=new JSONObject();
        request.put("firstName","Tom");
        request.put("lastName","Cooper");
        request.put("subject",1);

        baseURI="http://localhost:3000/";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json")
                .body(request.toJSONString()).
                when().post("/users").
                        then().
                statusCode(201).log().all();
    }
    @Test
    public void test_patch(){

        JSONObject request=new JSONObject();

        request.put("lastName","Shephered");

        baseURI="http://localhost:3000/";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json")
                .body(request.toJSONString()).
                when().patch("/users/4").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void test_put(){

        JSONObject request=new JSONObject();

        request.put("firstName","Mary");
        request.put("lastName","Jane");
        request.put("subjectId",1);

        baseURI="http://localhost:3000/";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json")
                .body(request.toJSONString()).
                when().put("/users/4").
                then().
                statusCode(200).log().all();
    }

    @Test
    public void test_delete(){

        baseURI="http://localhost:3000/";
        when()
                .delete("/users/4")
                .then().statusCode(200);
    }
}
