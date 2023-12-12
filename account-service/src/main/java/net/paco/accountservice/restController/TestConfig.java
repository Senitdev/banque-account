package net.paco.accountservice.restController;
import net.paco.accountservice.config.GlobalConf;
import net.paco.accountservice.config.GlobalConfig;
import net.paco.accountservice.service.BankAcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import  java.util.Map;
@RefreshScope
@RestController
public class TestConfig {
    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;
    @Value("${global.params.x}")
    private int x;
    @Value("${global.params.y}")
    private int y;
    @GetMapping("/testconfig")
    public  Map<String,Integer> configTest(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
    public TestConfig(){

    }
    /*
    @Autowired
    private GlobalConfig globalConfig;
    @GetMapping("/globalconfig")
    public GlobalConfig globalConfig(){
        return  globalConfig;
    }
    */
    GlobalConf globalConf;
    @GetMapping("/globalconf")
    public GlobalConf globalConf() {
     globalConf.setP1(100);
     globalConf.setP2(200);
     globalConf.setX(300);
     globalConf.setY(400);
        return globalConf;
    }
}
