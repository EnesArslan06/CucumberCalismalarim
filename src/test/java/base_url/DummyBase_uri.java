package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBase_uri {
    protected RequestSpecification specDummy;

    @Before
    public void setUp() throws Exception {
        specDummy=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();
    }

}
