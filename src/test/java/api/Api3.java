package api;

import base_url.RegresBase_url;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Api3 extends RegresBase_url {
       /*
    https://restful-booker.herokuapp.com/booking/5 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    ve content type'inin "application/json"
    ve firstname'in “Jim"
    ve totalprice’in 600
    ve checkin date'in 2015-06-12"oldugunu test edin
     */
    @Test
    public void test(){
        Response response =given().when().get("https://restful-booker.herokuapp.com/booking/5");

        /*response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Mary"),
                "totalprice", equalTo(313),
                        "bookingdates.checkin", equalTo("2016-10-01"),
                       "additionalneeds", equalTo("Breakfast"))
                .headers("Server", equalTo("Cowboy"),
                        "Connection", equalTo("keep-alive"),
                        "Content-Length", equalTo("169"));*/
        response.prettyPeek();
        Gson gson = new Gson();
        Map<String, Object> actuel=response.as(HashMap.class);
        String jsonFromJava = gson.toJson(actuel);
        System.out.println("actuelMap = " + actuel);
        System.out.println("jsonFromJava = " + jsonFromJava);
    }
    @Test
    public void test2(){
   /*  https://reqres.in/api/users URL request olustur.
    body icerisindeki idsi 5 olan datayi
    1) Matcher CLASS ile
    2) JsonPath ile dogrulayin.*/
    specRegres.pathParams("parametre1","api","parametre2","users");
    Response response =given().spec(specRegres).when().get("/{parametre1}/{parametre2}");
    response.prettyPeek();
    response.then().assertThat().statusCode(200).contentType("application/json")
            .body("data[4].id",equalTo(5),
                    "data[4].email",equalTo("charles.morris@reqres.in"),
                   "data[4].first_name",equalTo("Charles"),
                    "data[4].last_name",equalTo("Morris"),
                    "data[4].avatar",equalTo("https://reqres.in/img/faces/5-image.jpg"));

    JsonPath json=response.jsonPath();
        System.out.println(json.getList("data.first_name"));
        System.out.println(json.getList("data.last_name"));
        System.out.println(json.getList("data.email"));
        System.out.println(json.getInt("data[5].id"));

        assertEquals(json.getInt("data[5].id"),6);
        assertEquals(json.getString("data[5].first_name"),"Tracey");
        assertEquals(json.getString("data[5].last_name"),"Ramos");

    }
}
