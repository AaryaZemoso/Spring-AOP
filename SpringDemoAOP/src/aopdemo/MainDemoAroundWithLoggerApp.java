package aopdemo;

import aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainDemoAroundWithLoggerApp {

    private static Logger logger = Logger.getLogger(MainDemoAroundWithLoggerApp.class.getName());

    public static void main(String[] args) {

        // Read config
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the bean from spring
        TrafficFortuneService tf = applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info(tf.getFortune());

        // Close context
        applicationContext.close();
    }
}
