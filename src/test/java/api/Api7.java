package api;

import base_url.DummyBase_uri;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Api7 extends DummyBase_uri {
     /*
   http://dummy.restapiexample.com/api/v1/employees
   1) Status kodunun 200,
   2) 10’dan büyük tüm id’leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu,
   3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu
   4) Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın
      ve bunların içerisinde “Charde Marshall” olduğunu test edin
   */

    @Test
    public void test(){
      specDummy.pathParams("bir", "api", "iki", "v1", "uc", "employees");
      Response response=given().spec(specDummy).when().get("{bir}/{iki}/{uc}");
      response.prettyPrint();

      JsonPath json =response.jsonPath();
        List<Integer> idLer= json.getList("data.id");
        List<String> nameLer=new ArrayList<>();
        System.out.println("idLer = " + idLer);

        for (int i = 0; i < 24; i++) {
        if (json.getInt("data["+i+"].employee_salary")>350000) {
            System.out.println(json.getString("data[" + i + "].employee_name"));
            nameLer.add(json.getString("data[" + i + "].employee_name"));
        }
        }
        Assert.assertTrue(nameLer.contains("Charde Marshall"));
    }
}
