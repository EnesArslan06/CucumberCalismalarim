package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RegresBase_url {
    protected RequestSpecification specRegres;

    @Before
    public void setup() {
        specRegres = new RequestSpecBuilder().setBaseUri("https://reqres.in").build();
    }
}