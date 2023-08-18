package br.com.nathan.ecommerce.main.modules.customer.adapter.mapper;

import br.com.nathan.ecommerce.main.core.mapper.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerEntity implements Mapper<Customer, CustomerEntity> {

    @Override
    public CustomerEntity map(Customer raw) {
        return  new CustomerEntity()
                    .withId(raw.getId())
                    .withName(raw.getName().getValue())
                    .withEmail(raw.getEmail().getValue())
                    .withCpf(raw.getCpf().getValue())
                    .withPassword(raw.getPassword().getValue())
                    .withActive(raw.getActive());

    }
}
