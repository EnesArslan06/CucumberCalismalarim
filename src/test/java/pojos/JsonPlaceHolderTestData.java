package pojos;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String, Object> JsonPlaceHoldersetupData(){

        Map<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("completed", false);
        expectedData.put("userId", 1);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("Server", "cloudflare");

        return expectedData;
    }
}
