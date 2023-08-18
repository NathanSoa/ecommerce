package br.com.nathan.ecommerce.main.modules.customer.adapter.mapper;

import br.com.nathan.ecommerce.main.core.mapper.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerDTO;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToCustomer implements Mapper<CustomerDTO, Customer> {

    @Override
    public Customer map(CustomerDTO raw) {
        return Customer.Create()
                .withName(raw.name())
                .withEmail(raw.email())
                .withPassword(raw.password())
                .withCPF(raw.cpf())
                .withActive(raw.active());
    }
}
