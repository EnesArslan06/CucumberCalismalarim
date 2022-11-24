package api;

import base_url.HeroquappBase_uri;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import pojos.HerokuuAppTEstData;

import static io.restassured.RestAssured.given;

public class Api10Post extends HeroquappBase_uri {
     /*
       https://restful-booker.herokuapp.com/booking
       { "firstname": "Ali",
                  "lastname": "Can",
                  "totalprice": 500,
                  "depositpaid": true,
                  "bookingdates": {
                      "checkin": "2022-03-01",
                      "checkout": "2022-03-11"
                   }
    }
    gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
    }
       "booking": {
           "firstname": "Ali",
           "lastname": "Can",
           "totalprice": 500,
           "depositpaid": true,
           "bookingdates": {
                               "checkin": "2022-03-01",
                                "checkout": "2022-03-11"
           }
       }
    }
    olduğunu test edin
        */
    @Test
    public void test(){
        heroquappSpec.pathParam("bir","booking");
        HerokuuAppTEstData herokuuAppTEstData=new HerokuuAppTEstData();
        JSONObject expectedData=herokuuAppTEstData.setupTestData();
        Response response = given()
                .contentType("application/json; charset=utf-8")
                .auth()
                .basic("admin","password123")
                .spec(heroquappSpec)
                .body(expectedData.toString())
                .when()
                .post("{bir}");
        //JSONObject'te toString() kullanmalıyız. (.body(expectedRequestData.toString())

        response.prettyPrint();
        JsonPath actuelData=response.jsonPath();
        Assert.assertEquals(expectedData.getString("firstname"),actuelData.getString("booking.firstname"));
        Assert.assertEquals(expectedData.getString("lastname"),actuelData.getString("booking.lastname"));
        Assert.assertEquals(expectedData.getBoolean("depositpaid"),actuelData.getBoolean("booking.depositpaid"));

        Assert.assertEquals(expectedData.getJSONObject("bookingdates").getString("checkin"),
                actuelData.getString("booking.bookingdates.checkin"));

    }
}
