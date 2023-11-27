package br.com.nathan.ecommerce.main.modules.customer.repository.dao;

import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.interfaces.IDAO;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.jpa.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class CustomerDAO implements IDAO<CustomerEntity> {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return customerRepository.save(entity);
    }


    @Override
    public void deleteById(Long id) {
        this.findById(id);
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("customer.not-found"));
    }

    @Override
    public Set<CustomerEntity> findAll() {
        return new HashSet<>(customerRepository.findAll());
    }
}
