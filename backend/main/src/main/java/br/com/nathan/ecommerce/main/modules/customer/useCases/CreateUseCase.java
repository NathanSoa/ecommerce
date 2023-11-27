package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.core.interfaces.Strategy;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUseCase {

    private final IDAO<CustomerEntity> repository;
    private final Mapper<Customer, CustomerEntity> mapper;
    private final Strategy<Customer> businessRules;

    public Customer execute(Customer customer) {
        businessRules.process(customer);
        final var customerdb = repository.save(mapper.map(customer));
        customer.setId(customerdb.getId());
        return customer;
    }
}
