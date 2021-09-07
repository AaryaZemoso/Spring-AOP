package webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapp.dao.CustomerDAO;
import webapp.entity.Customer;
import webapp.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public String listCustomer(Model theModel)
    {
        List<Customer> customers = customerService.getCustomers();

        theModel.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {

        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer cust)
    {
        customerService.saveCustomer(cust);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate( @RequestParam("customerId") int id, Model theModel)
    {
        Customer customer = customerService.getCustomer(id);

        theModel.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id)
    {
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
