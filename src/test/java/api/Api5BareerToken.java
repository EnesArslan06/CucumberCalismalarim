package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Api5BareerToken {

    @Test
    public void test(){
        String username="Batch44Api";
        String passWord="Batch44+";

        Map<String, Object> sifre=new HashMap<>();
        sifre.put("username", username);
        sifre.put("password", passWord);

        String endPoint="https://www.gmibank.com/api/authenticate";

        Response response =given().contentType(ContentType.JSON).body(sifre).when().post(endPoint);
        response.prettyPrint();
        JsonPath token=response.jsonPath();
        System.out.println("token: "+ token.getString("id_token"));
        String tokenString=token.getString("id_token");

        Response response2=given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + tokenString)
                .when().get("http://www.gmibank.com/api/tp-customers/114351");

        response2.prettyPrint();
        response2.then().assertThat().statusCode(200).contentType("application/json");
        JsonPath json =response2.jsonPath();
        //Matcher ile
        response2.then().assertThat().body("firstName", equalTo("Della"),
                "lastName",equalTo("Heaney"),
                "country.id",equalTo(3),
                "country.name",equalTo("USA"),
                "state",equalTo("New York43"),
                "accounts[0].id",equalTo(2333),
                "accounts[0].description",equalTo("musteri omer hesap3"),
        "accounts[1].balance",equalTo(11190),
          "accounts[1].accountType",equalTo("CHECKING"));


            //Json ile
        Assert.assertEquals("123-456-7893",json.getString("mobilePhoneNumber"));
        Assert.assertEquals("Della",json.getString("firstName"));
        Assert.assertEquals("USA",json.getString("country.name"));
        Assert.assertEquals("New York43",json.getString("state"));
        Assert.assertEquals("musteri omer hesap3",json.getString("accounts[0].description"));
        Assert.assertEquals(69700,json.getInt("accounts[0].balance"));
        Assert.assertEquals(107250,json.getInt("accounts[1].id"));
        Assert.assertEquals("CHECKING",json.getString("accounts[1].accountType"));


    }
}
