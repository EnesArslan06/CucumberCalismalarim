package pojos;

import org.json.JSONObject;
import org.junit.Test;

public class HerokuuAppTEstData {

    public  JSONObject setupTestData(){
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2022-03-01");
        bookingdates.put("checkout","2022-03-11");

        JSONObject jsonObje=new JSONObject();
        jsonObje.put("firstname","Ali");
        jsonObje.put("lastname","Can");
        jsonObje.put("totalprice",500);
        jsonObje.put("depositpaid",true);
        jsonObje.put("bookingdates",bookingdates);



        return jsonObje;

    }
}
