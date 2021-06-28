package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//@Controller
//public class CustomerController {
//    private CustomerService customerService = CustomerServiceFactory.getInstance();
//
//    @GetMapping("/customers")
//    public String showList(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customers/list.jsp";
//    }
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public ModelAndView update(@RequestParam Long id, String name, String email, String address){
//        Customer customer = new Customer(id, name, email, address);
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
//        List<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
//    @RequestMapping(value="/delete")
//    public ModelAndView delete(@RequestParam Long id){
//        customerService.delete(id);
//        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
//        List<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers",customers);
//        return modelAndView;
//    }
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addCustomer(@RequestParam String name, String email, String address){
//        Customer customer = new Customer(name, email, address);
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
//        List<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
//}
@Controller
@RequestMapping({"", "/customers"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showListCustomers() {
        ModelAndView modelAndView = new ModelAndView("customer/add");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customer/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    //    @PostMapping()
    //    public String updateCustomer(Long id, String name, String email, String address) {
    //        Customer customer = new Customer(id, name, email, address);
    //        customerService.save(customer);
    //        return "redirect:/customers";
    //    }

    @PostMapping()
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }
}
