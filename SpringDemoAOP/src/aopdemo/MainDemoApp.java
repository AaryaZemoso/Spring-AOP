package aopdemo;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // Read config
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the bean from spring
        AccountDAO accountBean = applicationContext.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipBean = applicationContext.getBean("membershipDAO", MembershipDAO.class);

        // Call the business method
        accountBean.addAccount(new Account("Sanath Anna", "Noob"));
        accountBean.findAccounts(true);

        System.out.println();

        membershipBean.addAccount();

        // Getter and Setter Methods
        accountBean.setName("Teja Anna");
        accountBean.getName();

        accountBean.setServiceCode("Upppeeeeennnnndddrrraaaaaaaaa");
        accountBean.getServiceCode();

        // Close context
        applicationContext.close();
    }
}
