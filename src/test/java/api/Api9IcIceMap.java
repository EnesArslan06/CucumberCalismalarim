package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api9IcIceMap {
       /*
   https://restful-booker.herokuapp.com/booking/12
          {
    "firstname": "asd",
    "lastname": "sa",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
   1) JsonPhat
   2) De-Serialization*/
   @Test
    public void test(){
       HashMap<String,Object> expectedData = new HashMap<String,Object>();
       HashMap<String,Object> mapIcteki = new HashMap<String,Object>();
       mapIcteki.put("checkin","2018-01-01");
       mapIcteki.put("checkout","2019-01-01");
       expectedData.put("firstname","asd");
       expectedData.put("lastname","sa");
       expectedData.put("totalprice",111);
       expectedData.put("depositpaid",true);
       expectedData.put("bookingdates",mapIcteki);
       expectedData.put("additionalneeds","Breakfast");

       Response response =given().when().get("https://restful-booker.herokuapp.com/booking/12");
       response.prettyPrint();
       System.out.println("expectedData = " + expectedData);

       HashMap<String,Object> actualData=response.as(HashMap.class);
       System.out.println("actualData = " + actualData);


       Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),
               ((Map)actualData.get("bookingdates")).get("checkin"));
       JsonPath jsonPath =response.jsonPath();
       Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin")
               ,jsonPath.getString("bookingdates.checkin"));

   }
}
