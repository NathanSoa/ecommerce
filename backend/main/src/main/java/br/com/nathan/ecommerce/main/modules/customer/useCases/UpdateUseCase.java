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
public class UpdateUseCase {

    private final IDAO<CustomerEntity> repository;
    private final Mapper<Customer, CustomerEntity> mapper;
    private final Strategy<Customer> businessRules;

    public Customer execute(Customer customer, Long id) {
        businessRules.process(customer);
        repository.findById(id);
        customer.setId(id);
        repository.save(mapper.map(customer));
        return customer;
    }
}
