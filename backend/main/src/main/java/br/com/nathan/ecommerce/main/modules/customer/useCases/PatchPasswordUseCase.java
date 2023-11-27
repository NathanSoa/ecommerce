package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchPasswordUseCase {

    private final IDAO<CustomerEntity> repository;

    public void execute(Long id, String password) {
        var customer = repository.findById(id);
        customer.setPassword(password);
        repository.save(customer);
    }
}
