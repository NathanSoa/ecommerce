package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.mapper.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUseCase {

    private final CustomerRepository repository;
    private final Mapper<Customer, CustomerEntity> mapper;

    public Customer execute(Customer customer, Long id) {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("customer.not-found"));
        customer.setId(id);
        repository.save(mapper.map(customer));
        return customer;
    }
}
