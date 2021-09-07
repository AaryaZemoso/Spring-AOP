package aopdemo.dao;

import aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + " getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass() + " setName()");
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean tripWire){

        if(tripWire)
        {
            throw new RuntimeException("Sanath ivanu anadu");
        }

        List<Account> list = new ArrayList<>();

        list.add(new Account("Uppppiiii", "Bronze"));
        list.add(new Account("Tejjjjjaaaaa", "Wood"));
        list.add(new Account("Poti Sanath", "Paper"));
        list.add(new Account("Aarya", "Gold"));

        return list;
    }

    public void addAccount(Account a){
        System.out.println(getClass() + ": Doing my DB Work: adding account");
    }
}
