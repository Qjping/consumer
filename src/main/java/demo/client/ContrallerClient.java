package demo.client;


import demo.domain.Book;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "product")

public interface ContrallerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/get/{num}")
    Book get(@PathVariable Integer num);
}