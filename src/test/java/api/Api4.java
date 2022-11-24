package api;

import base_url.DummyBase_uri;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Api4 extends DummyBase_uri {
    /* http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
 1) Butun calisanlarin isimlerini consola yazdıralim
 2) 3. calisan kisinin ismini konsola yazdıralim
 3) Ilk 5 calisanin adini konsola yazdiralim
 4) En son calisanin adini konsola yazdiralim*/
    @Test
    public void test() {
        specDummy.pathParams("bir", "api", "iki", "v1", "uc", "employess");
        Response response = given().spec(specDummy).when().get("/{bir}/{iki}/{uc}");
        //response.prettyPrint();
        Response response2 = given().when().get("http://dummy.restapiexample.com/api/v1/employees");
        response2.prettyPrint();

        JsonPath json = response2.jsonPath();
        System.out.println(json.getList("data.employee_name"));
        System.out.println(json.getString("data[2].employee_name"));
        List<String> isimler = json.getList("data.employee_name");
        for (int i = 0; i < 5; i++) {
            System.out.println(isimler.get(i));
        }
        System.out.println(isimler.get(isimler.size() - 1));
    }

    @Test
    public void test2() {
   /*  http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
    1) Matcher CLASS ile
    2) JsonPath ile dogrulayin.*/
        specDummy.pathParams("bir", "api", "iki", "v1", "uc", "employee", "dort", "12");
        Response response = given().spec(specDummy).when().get("/{bir}/{iki}/{uc}/{dort}");
        response.prettyPrint();

        response.then().assertThat().body("data.id", equalTo(12),
                "data.employee_name", equalTo("Quinn Flynn"),
                "data.employee_salary", equalTo(342000),
                "data.employee_age", equalTo(22)).statusCode(200).contentType("application/json");

        JsonPath json = response.jsonPath();
        assertEquals(12,json.getInt("data.id"));
        assertEquals("Quinn Flynn",json.getString("data.employee_name"));
        assertEquals(342000,json.getInt("data.employee_salary"));
    }
    @Test
    public void test3() {
    /* http://dummy.restapiexample.com/api/v1/employees
    url ine bir istek gönderildiğinde,
    status kodun 200,
    gelen body de,
    5. çalışanın isminin "Airi Satou" olduğunu ,
    6. çalışanın maaşının "372000" olduğunu ,
    Toplam 24 tane çalışan olduğunu,
    "Rhona Davidson" ın employee lerden biri olduğunu
    "21", "23", "61" yaşlarında employeeler olduğunu test edin
    JSONPATH KULLARAK*/
    specDummy.pathParams("bir", "api", "iki", "v1", "uc", "employees");
    Response response = given().spec(specDummy).when().get("/{bir}/{iki}/{uc}");
    response.prettyPrint();
    response.then().assertThat().statusCode(200).contentType("application/json");
    JsonPath json=response.jsonPath();
    Assert.assertEquals("Airi Satou",json.getString("data[4].employee_name"));
    Assert.assertEquals(372000,json.getInt("data[5].employee_salary"));
    Assert.assertEquals(24,(json.getList("data.id").size())) ;
    Assert.assertTrue((json.getList("data.employee_name")).contains("Rhona Davidson"));
    List<Integer> kontrol=new ArrayList<Integer>();
    kontrol.add(21); kontrol.add(23); kontrol.add(61);
    Assert.assertTrue(json.getList("data.employee_age").containsAll(kontrol));




    }
}