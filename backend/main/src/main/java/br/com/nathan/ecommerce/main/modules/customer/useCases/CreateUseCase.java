package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUseCase {

    private final CustomerRepository repository;
    private final Mapper<Customer, CustomerEntity> mapper;

    public Customer execute(Customer customer) {
        final var customerdb = repository.save(mapper.map(customer));
        customer.setId(customerdb.getId());
        return customer;
    }
}
