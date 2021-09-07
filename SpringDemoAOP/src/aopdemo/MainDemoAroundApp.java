package aopdemo;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoAroundApp {
    public static void main(String[] args) {

        // Read config
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the bean from spring
        TrafficFortuneService tf = applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println(tf.getFortune());

        // Close context
        applicationContext.close();
    }
}
