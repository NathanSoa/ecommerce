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
public class CustomerEntityToCustomer implements Mapper<CustomerEntity, Customer> {

    private final Mapper<AddressEntity, Address> addressMapper;

    @Override
    public Customer map(CustomerEntity raw) {
        return Customer.Create()
                .withId(raw.getId())
                .withCPF(raw.getCpf())
                .withEmail(raw.getEmail())
                .withName(raw.getName())
                .withPassword(raw.getPassword())
                .withActive(raw.getActive())
                .withAddress(raw.getAddressEntity().stream().map(addressMapper::map).toList());
    }
}
