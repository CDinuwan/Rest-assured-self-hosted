import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test_POST {

    @Test
    public void test_1_post(){

        Map<String,Object> map=new HashMap<String, Object>();

        map.put("name","Chanuka");
        map.put("job","Teacher");

        System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name","dinuwan");
        request.put("jon","teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
        .then()
        .statusCode(201);
    }

    @Test
    public void test_2_put(){

        Map<String,Object> map=new HashMap<String, Object>();

        map.put("name","Chanuka");
        map.put("job","Teacher");

        System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name","dinuwan");
        request.put("jon","teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void test_3_patch(){

        Map<String,Object> map=new HashMap<String, Object>();

        map.put("name","Chanuka");
        map.put("job","Teacher");

        System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name","dinuwan");
        request.put("jon","teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void test_4_delete(){

                given()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204).log().all();
    }
}
