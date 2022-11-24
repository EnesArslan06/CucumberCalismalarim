package api;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Api2 {

   /* {
        "firstname": "Mark",
            "lastname": "Jones",
            "totalprice": 175,
            "depositpaid": true,
            "bookingdates": {
        "checkin": "2016-05-15",
                "checkout": "2021-11-21"
    },
        "additionalneeds": "Breakfast"
    }*/
    @Test
    public void test(){
        String path="https://restful-booker.herokuapp.com/booking/7";
        Response response =given().when().get(path);
        response.prettyPeek();
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Jones"),
                       "bookingdates.checkin",equalTo("2016-05-15"),
                        "depositpaid",equalTo(true));
    }

    /*
   http://dummy.restapiexample.com/api/v1/employees  url'ine
   GET request'i yolladigimda gelen response'un
   status kodunun 200 ve content type'inin "application/json"
   ve employees sayisinin 24
   ve employee'lerden birinin "Ashton Cox"
   ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
   */
    @Test
    public void test2(){
      String path="http://dummy.restapiexample.com/api/v1/employees";
      Response response =given().when().get(path);
      response.prettyPeek();
      response.then().assertThat().statusCode(200).contentType("application/json");

      response.then().assertThat().body("data",Matchers.hasSize(24),
              "data.employee_name",Matchers.hasItem("Tatyana Fitzpatrick"),
              "data.employee_age",Matchers.hasItems(21,61,23));

    }
    /*
       https://jsonplaceholder.typicode.com/todos/123 url'ine
        GET request'i yolladigimda gelen response’un
		status kodunun 200
   		ve content type'inin "application/json"
		ve Headers'daki "Server" in "cloudflare"
		ve response body'deki "userId"'nin 7
		ve "title" in "esse et quis iste est earum aut impedit"
		ve "completed" bolumunun false oldugunu test edin
     */
    //body ve headers test bir arada yapilabilir
    @Test
    public void test3(){
        String path="https://jsonplaceholder.typicode.com/todos/123";
        Response response =given().when().get(path);
        response.prettyPeek();
        response.then().assertThat().statusCode(200).contentType("application/json");
        response.then().assertThat().headers("Server",Matchers.equalTo("cloudflare"),
                "Pragma",equalTo("no-cache"),
                "Expires",equalTo("-1"))
                .body("title",equalTo("esse et quis iste est earum aut impedit"),
                        "completed",equalTo(false));

    }
}
