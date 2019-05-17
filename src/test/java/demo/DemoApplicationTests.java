package demo;


import demo.client.ContrallerClient;
import demo.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids={"com.example.book:product:+:8099"},stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class DemoApplicationTests {
    @Autowired
    private ContrallerClient contrallerClient;

    @Test
    public void contextLoads() {
        Book s=contrallerClient.get(2);
        Book book=new Book();
        System.out.println(s.toString());
        book.setName("战国策");
        Assert.assertEquals(s.getName(),book.getName());
    }

}
