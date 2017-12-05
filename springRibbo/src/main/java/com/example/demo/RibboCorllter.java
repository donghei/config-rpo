package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/12/012.
 */
@RestController
public class RibboCorllter {
    @Autowired
    private  ServiceRibbo serviceRibbo;


    @RequestMapping(value="/hi")
    public String hi(@RequestParam String name){
        return serviceRibbo.hiRibbo(name);
    }


}
