package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.ICustomerRepository;
import com.codegym.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    private CustomerController customerController;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllCustomerPage() {
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> allCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PutMapping("{/id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

//    @Autowired
//    private ICustomerService customerService;
//    @ModelAttribute
//    public Customer customer(){
//        return new Customer();
//    }
//
//    @PostMapping
//    public ResponseEntity<Customer> createSmartphone(@RequestBody Customer customer) {
//        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
//    }
//    @GetMapping("")
//    public ModelAndView getAllSmartphonePage() {
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("customers", customerService.findAll());
//        return modelAndView;
//    }

//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        List<Customer> customers = customerService.findAll()
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("customers", customers);
////        modelAndView.addObject("message", "New customer created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("")
//    public ModelAndView listCustomers() {
//        List<Customer> customers = customerService.findAll();
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

//    @GetMapping("/edit-customer/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("list");
//            modelAndView.addObject("edit", customer);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-customer")
//    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete-customer/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("list");
//            modelAndView.addObject("delete", customer);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete-customer")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.remove(customer.getId());
//        return "redirect:customers";
//    }

}
