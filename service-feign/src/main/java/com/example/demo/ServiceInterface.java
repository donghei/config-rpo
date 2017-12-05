package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**e
 * Created by Administrator on 2017/7/12/012.
 */

@FeignClient(value = "SERVICE-CLI",fallback = ServiceInterfaceHystric.class)

public interface ServiceInterface {
    @RequestMapping(value = "/hi")
    String sayHi(@RequestParam(value = "name") String name);
}
