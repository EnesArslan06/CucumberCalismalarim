package api;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Api1 {

    @Test
    public void getRequest1(){
        String url = "https://automationexercise.com/api/productsList";
         System.out.println("Merhaba");
        Response response =given().when().get(url);
        response.prettyPrint();
        System.out.println("content Type: "+response.contentType());
        System.out.println("statusLine: "+response.statusLine());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getContentType(), "text/html; charset=utf-8");

        //diger dogrulama yontemi
        response.then()
                    .assertThat()
                   .contentType("text/html; charset=utf-8")
                    .statusCode(200)
                    .statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void getRequest2(){
        Response response=given().when().get("https://reqres.in/api/users/1");
        response.prettyPrint();
        response.then().assertThat()
                .body("data.id", equalTo(1),
                   "data.email",equalTo("george.bluth@reqres.in"),
                        "data.first_name",equalTo("George"),
                        "data.last_name",equalTo("Bluth"),
                        "support.url",equalTo("https://reqres.in/#support-heading"));

        System.out.println(response.getContentType());
    }
}
