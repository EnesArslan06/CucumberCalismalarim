package api;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Api13ObjectMapper {
 /*https://jsonplaceholder.typicode.com/todos/198 url’ine bir get request gönderildiğinde,
Dönen response ‘un status kodunun 200 ve body kısmının
 {
 "userId": 10,
 "id": 198,
 "title": "quis eius est sint explicabo",
 "completed": true
 }Olduğunu Object Mapper kullanarak test edin*/

@Test
    public void test(){
    Response response =given().when().get("https://jsonplaceholder.typicode.com/todos/198");
    response.prettyPrint();




}

}
