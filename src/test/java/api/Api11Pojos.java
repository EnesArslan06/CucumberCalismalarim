package api;

import base_url.JsonPlaceHolderBase_uri;
import io.cucumber.messages.JSON;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonplaceholderPojos;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class Api11Pojos extends JsonPlaceHolderBase_uri {
     /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
    Request body{
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
    Status kodun 201, response body ‘nin ise

    {
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
    */
    @Test
    public void test(){
        specJsonPlaceHolder.pathParam("bir","todos");
        JsonplaceholderPojos jsonPojos = new
                JsonplaceholderPojos(21,201,"Tidy your room",false);
        System.out.println(jsonPojos);

        Response response =given().spec(specJsonPlaceHolder).
                contentType(ContentType.JSON).body(jsonPojos).
                when().post("/{bir}");
        response.prettyPrint();
        JsonPath actualData=response.jsonPath();

       Assert.assertEquals(jsonPojos.getCompleted(),actualData.get("completed"));
       Assert.assertEquals(jsonPojos.getId(),actualData.getInt("id"));
       Assert.assertEquals(jsonPojos.getUserId(),actualData.getInt("userId"));
       Assert.assertEquals(jsonPojos.getTitle(),actualData.get("title"));
    }

}
