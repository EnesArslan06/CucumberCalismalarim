package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingPojos;
import pojos.BookingdatesPojos;

import static io.restassured.RestAssured.given;

public class Api12Pojos {
        /*
      {
     "bookingid": 11,

    "firstname": "Sally",
    "lastname": "Ericsson",
    "totalprice": 115,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2020-11-08",
        "checkout": "2021-01-10"
    }
}
                      }
     */

    @Test
    public void test() {
        BookingdatesPojos bookingdates =
                new BookingdatesPojos("2020-11-08", "2021-01-10");
        BookingPojos bookingPojos =
                new BookingPojos("Sally", "Ericsson", 115, false, bookingdates);

        System.out.println("bookingdatesPojos = " + bookingdates);
        System.out.println("bookingPojos = " + bookingPojos);

        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/2");
        response.prettyPrint();

        JsonPath jsonActual = response.jsonPath();
        Assert.assertEquals(bookingdates.getCheckin(), jsonActual.getString("bookingdates.checkin"));
        Assert.assertEquals(bookingdates.getCheckout(), jsonActual.getString("bookingdates.checkout"));

        Assert.assertEquals(bookingPojos.getBookingdates().getCheckin(),
                jsonActual.getString("bookingdates.checkin"));
        Assert.assertEquals(bookingPojos.getBookingdates().getCheckout(),
                jsonActual.getString("bookingdates.checkout"));

        Assert.assertEquals(bookingPojos.getFirstname(),jsonActual.getString("firstname"));
        Assert.assertEquals(bookingPojos.getLastname(),jsonActual.getString("lastname"));
        Assert.assertEquals(bookingPojos.getTotalprice(),jsonActual.getInt("totalprice"));
        Assert.assertEquals(bookingPojos.isDepositpaid(),jsonActual.getBoolean("depositpaid"));
    }
}