package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/7/13/013.
 */
@Component
public class ServiceInterfaceHystric  implements  ServiceInterface{
    @Override
    public String sayHi( String name) {
        return "sorry "+name;
    }
}
