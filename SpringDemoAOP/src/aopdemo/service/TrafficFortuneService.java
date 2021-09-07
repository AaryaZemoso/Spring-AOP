package aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(){

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            System.out.println("Exception in Service : " + e);
        }

        return "Good luck with the traffic today!!!";
    }

    public String getFortune(boolean tripWire) {

        if(tripWire)
            throw new RuntimeException("Tornado Alert");

        return getFortune();
    }
}
