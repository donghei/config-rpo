package com.example.demo;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/7/12/012.
 */
@Service
public class ServiceRibbo {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hieroor")
    public String hiRibbo(String name){
        return restTemplate.getForObject("http://SERVICE-CLI/hi?name="+name,String.class);
    }
    public String hieroor(String name){
        return "baocuo"+name;
    }

}
