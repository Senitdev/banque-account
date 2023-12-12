package net.paco.gatewayservice.TestConfig;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class testconfig {
    @Value("${global.param.x}")
    private int x;
    @Value("${global.param.y}")
    private int y;
@GetMapping("/testconf")
    public Map<String,Integer>config(){
        return Map.of("x",x,"y",y);
    }
    
}
