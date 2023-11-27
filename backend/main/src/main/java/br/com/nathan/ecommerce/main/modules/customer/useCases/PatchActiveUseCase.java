package br.com.nathan.ecommerce.main.modules.customer.useCases;

import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatchActiveUseCase {

    private final IDAO<CustomerEntity> repository;
    private final Mapper<CustomerEntity, Customer> mapper;

    public Customer execute(Long id, Boolean active) {
        var customer = repository.findById(id);
        customer.setActive(active);
        repository.save(customer);
        return mapper.map(customer);
    }
}
