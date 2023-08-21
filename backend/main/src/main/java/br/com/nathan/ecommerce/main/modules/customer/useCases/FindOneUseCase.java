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
public class FindOneUseCase {

    private final CustomerRepository repository;
    private final Mapper<CustomerEntity, Customer> mapper;

    public Customer execute(Long id) {
        final var data = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("customer.not-found"));
        return mapper.map(data);
    }
}
