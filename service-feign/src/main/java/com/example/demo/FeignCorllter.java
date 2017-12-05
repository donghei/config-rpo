package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/12/012.
 */
@RestController
public class FeignCorllter {


    @Autowired
    ServiceInterface serviceInterface;
    @RequestMapping(value = "/hi")
    public String sayHiFeign(@RequestParam (value = "name")String name){

        return  serviceInterface.sayHi(name);
    }
}
