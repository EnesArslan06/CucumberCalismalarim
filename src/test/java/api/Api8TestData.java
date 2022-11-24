package api;

import base_url.JsonPlaceHolderBase_uri;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api8TestData extends JsonPlaceHolderBase_uri {
  /* https://jsonplaceholder.typicode.com/todos/2
   1) Status kodunun 200,
   2) respose body'de,
            "completed": değerinin false
            "title”: değerinin “quis ut nam facilis et officia qui”
            "userId" sinin 1 ve
       header değerlerinden
            "via" değerinin “1.1 vegur” ve
            "Server" değerinin “cloudflare” olduğunu test edin…*/

    @Test
    public void test(){
        specJsonPlaceHolder.pathParams("1", "todos", "2", 2);
        JsonPlaceHolderTestData jsonPlaceExpected = new JsonPlaceHolderTestData();
        Response response =given().spec(specJsonPlaceHolder).when().get("/{1}/{2}");
        response.prettyPrint();
        Map<String,Object> expectedData=jsonPlaceExpected.JsonPlaceHoldersetupData();
        Map<String,Object> actuelData=response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
        Assert.assertEquals(expectedData.get("via"),response.header("via"));
        Assert.assertEquals(expectedData.get("Server"),response.header("Server"));
        Assert.assertEquals(expectedData.get("userId"),actuelData.get("userId"));
        Assert.assertEquals(expectedData.get("completed"),actuelData.get("completed"));
        Assert.assertEquals(expectedData.get("title"),actuelData.get("title"));



    }

}
