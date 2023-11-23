package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchActiveUseCase {

    private final CustomerRepository repository;
    private final Mapper<CustomerEntity, Customer> mapper;

    public Customer execute(Long id, Boolean active) {
        var customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("customer.not-found"));
        customer.setActive(active);
        customer = repository.save(customer);
        return mapper.map(customer);
    }
}
