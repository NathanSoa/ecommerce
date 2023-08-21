package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.modules.customer.factory.Validators;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchPasswordUseCase {

    private final CustomerRepository repository;

    public void execute(Long id, String password) {
        var customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("customer.not-found"));
        Validators.passwordValidator().validate(password);
        customer.setPassword(password);
        repository.save(customer);
    }
}
