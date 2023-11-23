package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindAllUseCase {

    private final CustomerRepository repository;
    private final Mapper<CustomerEntity, Customer> mapper;

    public Set<Customer> execute() {
        return repository.findAll()
                .stream().map(mapper::map)
                .collect(Collectors.toSet());
    }
}
