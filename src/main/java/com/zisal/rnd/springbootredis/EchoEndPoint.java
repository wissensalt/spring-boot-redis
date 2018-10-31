package com.zisal.rnd.springbootredis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController("/echo")
public class EchoEndPoint {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
