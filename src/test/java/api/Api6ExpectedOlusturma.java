package api;

import base_url.JsonPlaceHolderBase_uri;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api6ExpectedOlusturma extends JsonPlaceHolderBase_uri {
  /*  https://jsonplaceholder.typicode.com/todos/7
  { "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false} */
   @Test
    public void test(){
       specJsonPlaceHolder.pathParams("bir","todos","iki",7);
       Response response =given().spec(specJsonPlaceHolder).when().get("/{bir}/{iki}");
       response.prettyPrint();

       Map<String,Object> expectedData = new HashMap<>();
       expectedData.put("userId",1);
       expectedData.put("id",7);
       expectedData.put("title","illo expedita consequatur quia in");
       expectedData.put("completed",false);
       System.out.println("expectedData = " + expectedData);

      // De-Serialization aşağıdaki JSON formatındaki datayı map'e dönüştür.
       Map<String,Object> actualData = response.as(HashMap.class);
       System.out.println("actualData = " + actualData);

       Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
       Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
       Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
       Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));


   }


}
