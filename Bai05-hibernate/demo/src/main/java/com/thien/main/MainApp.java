package com.thien.main;

import com.thien.dao.CustomerDAO;
import com.thien.entities.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

        customerDAO.save(new Customer("Rooney", "Manchester"));
        customerDAO.save(new Customer("Gerrard", "Liverpool"));

        List<Customer> listCustomer = customerDAO.findAll();
        for (Customer customer : listCustomer) {
            System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getAddress());
        }
//
//    Customer customer = new Customer(1, "Gerrard", "Liverpool");
//    customerDAO.update(customer);
        context.close();
    }
}
