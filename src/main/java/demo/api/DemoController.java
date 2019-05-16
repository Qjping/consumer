package demo.api;


import demo.client.ContrallerClient;
import demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

   @Autowired
    private ContrallerClient ContrallerClient;

    @GetMapping("/v2/get/{num}")
    public Book get(@PathVariable int num){
        return ContrallerClient.get(num);
    }
}
