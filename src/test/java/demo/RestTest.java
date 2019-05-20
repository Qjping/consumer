package demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
@AutoConfigureStubRunner(ids={"com.example.book:product:+:8099"},stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
public class RestTest {
   @Autowired
    private RestTemplate restTemplate;
    @Test
    public void test1() throws JSONException {
//        ResponseEntity<JSONObject> response = restTemplate.exchange(
//                    "http://localhost:8099/v1/get/2",
//                    HttpMethod.GET,
//                    null,
//                    JSONObject.class
//            );

//        System.out.println(response.getBody());
        String result= restTemplate.getForEntity("http://localhost:8099/v1/get/2",String.class).getBody();

        JSONObject res=new JSONObject(result);

        Assert.assertEquals("战国策",res.get("name"));


    }

        @Test
        public void test() throws IOException, JSONException {
        HttpGet get = new HttpGet("http://localhost:8099/v1/get/1");
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpResponse httpResponse=defaultHttpClient.execute(get);

        String result= EntityUtils.toString(httpResponse.getEntity());
        JSONObject res=new JSONObject(result);
        System.out.println(res);
        Assert.assertEquals("资治通鉴",res.get("name"));

    }
//    @Test
//    public void validate_test() throws Exception {
//        MockMvcRequestSpecification request = RestAssuredMockMvc.given();
//        ResponseOptions response = RestAssuredMockMvc.given().spec(request).get("/v1/get/2", new Object[0]);
//        SpringCloudContractAssertions.assertThat(response.statusCode()).isEqualTo(200);
//        SpringCloudContractAssertions.assertThat(response.header("Content-Type")).isEqualTo("application/json;charset=UTF-8");
//        DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
//        JsonAssertion.assertThatJson(parsedJson).field("['name']").isEqualTo("战国策");
//    }

}