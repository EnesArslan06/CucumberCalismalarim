package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HeroquappBase_uri {
    protected RequestSpecification heroquappSpec;

    @Before
    public void setUp(){
        heroquappSpec=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/").build();
    }
}
