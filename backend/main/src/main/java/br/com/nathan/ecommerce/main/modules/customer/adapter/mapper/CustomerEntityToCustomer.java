package br.com.nathan.ecommerce.main.modules.customer.adapter.mapper;

import br.com.nathan.ecommerce.main.core.mapper.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityToCustomer implements Mapper<CustomerEntity, Customer> {

    @Override
    public Customer map(CustomerEntity raw) {
        return Customer.Create()
                .withCPF(raw.getCpf())
                .withEmail(raw.getEmail())
                .withName(raw.getName())
                .withPassword(raw.getPassword());
    }
}
