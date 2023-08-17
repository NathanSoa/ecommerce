package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUseCase {

    private final CustomerRepository repository;

    public void execute(Long id) {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find customer with id: " + id));
        repository.deleteById(id);
    }
}
