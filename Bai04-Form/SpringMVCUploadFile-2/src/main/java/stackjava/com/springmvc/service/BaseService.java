package stackjava.com.springmvc.service;

import stackjava.com.springmvc.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class BaseService {
    List<Customer> list = new ArrayList<Customer>();
    public List<Customer> findAll(){return list;}
    public void save(Customer customer){
        list.add(customer);
    }
}
