package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchActiveUseCase {

    private final CustomerRepository repository;

    public void execute(Long id, Boolean active) {
        var customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
        customer.setActive(active);
        repository.save(customer);
    }
}
