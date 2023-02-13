package com.rishavtechie.springbootwebflux.service;

import com.rishavtechie.springbootwebflux.dao.CustomerDao;
import com.rishavtechie.springbootwebflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    public List<Customer> loadAllCustomer(){  // print the excecution time //
        long start= System.currentTimeMillis();
        List<Customer> customer = dao.getCustomer();
        long end= System.currentTimeMillis();
        System.out.println("Total excecution time : " + (end - start));
        return customer;

    }

    public Flux<Customer> loadAllCustomersStream(){
        long start= System.currentTimeMillis();//implemention of flux//
        Flux<Customer> customers = dao.getCustomersStream();
        long end= System.currentTimeMillis();
        System.out.println("Total excecution time : " + (end - start));
        return customers;

    }
}
