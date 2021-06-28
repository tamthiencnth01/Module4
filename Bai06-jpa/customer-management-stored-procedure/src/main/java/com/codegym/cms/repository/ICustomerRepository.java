package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProdure(Customer customer);
}
