package dev.pepper.service;

import java.util.List;

import javax.inject.Inject;

import dev.pepper.grpc.customer.CustomerName;
import dev.pepper.grpc.customer.ListCustomers;
import dev.pepper.grpc.customer.Multiplyer;
import dev.pepper.model.Customer;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

@GrpcService
public class CustomersGrpcService implements dev.pepper.grpc.customer.CustomersService {

    @Inject
    CustomersService service;

    @Override
    @Blocking
    public Uni<ListCustomers> listAll (Multiplyer multiplyer) {
        List<Customer> list = service.list(multiplyer.getValue());
        return Uni.createFrom().item(service.fromCustomer(list));
    }

    @Override
    @Blocking
    public Uni<CustomerName> getNameById(dev.pepper.grpc.customer.Customer request) {
        Customer customer = service.find(request.getId());
        CustomerName cn = CustomerName.newBuilder().setCustomerName(customer.name).build();
        return Uni.createFrom().item(cn);
    }

}
