package dev.pepper.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.pepper.grpc.customer.ListCustomers;
import dev.pepper.model.Customer;

@ApplicationScoped
public class CustomersService {

    public Customer find (Long id) {
        return Customer.findById(id);
    }

    public List<Customer> list (int multiplier) {
        List<Customer> multiplyerList = new ArrayList<>();
        List<Customer> listDB = Customer.listAll();
        for (int i = 0; i < multiplier; i++) {
            multiplyerList.addAll(listDB);
        }
        return multiplyerList;
    }

    public ListCustomers fromCustomer (List<Customer> list) {
        ListCustomers.Builder builder = ListCustomers.newBuilder();
        list.forEach(it -> builder.addCustomer(fromCustomer(it)));
        return builder.build();
    }

    public dev.pepper.grpc.customer.Customer fromCustomer (Customer customer) {
        return dev.pepper.grpc.customer.Customer.newBuilder()
                .setId(customer.id)
                .setName(customer.name)
                .setEmail(customer.email)
                .setPhone(customer.phone)
                .setAddress(customer.address)
                .setZipCode(customer.zipCode)
                .setCpf(customer.cpf)
                .build();

    }
}
