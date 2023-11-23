package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.AddressEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerToCustomerEntity implements Mapper<Customer, CustomerEntity> {

    private final Mapper<Address, AddressEntity> addressMapper;

    @Override
    public CustomerEntity map(Customer raw) {
        return  new CustomerEntity()
                    .withId(raw.getId())
                    .withName(raw.getName().getValue())
                    .withEmail(raw.getEmail().getValue())
                    .withCpf(raw.getCpf().getValue())
                    .withPassword(raw.getPassword().getValue())
                    .withAddress(raw.getAddress().stream().map(addressMapper::map).toList())
                    .withActive(raw.getActive());

    }
}