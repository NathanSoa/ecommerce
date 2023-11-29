package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.*;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CardEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerEntityToCustomer implements Mapper<CustomerEntity, Customer> {

    private final Mapper<AddressEntity, Address> addressMapper;
    private final Mapper<CardEntity, Card> cardMapper;

    @Override
    public Customer map(CustomerEntity raw) {
        final var customer = Customer.Create();

        customer.setId(raw.getId());
        customer.setName(Name.withoutValidation(raw.getName()));
        customer.setEmail(Email.withoutValidation(raw.getEmail()));
        customer.setCpf(CPF.withoutValidation(raw.getCpf()));
        customer.setPhone(Phone.withoutValidation(raw.getPhone()));
        customer.setPassword(Password.withoutValidation(raw.getPassword()));
        customer.setActive(raw.getActive());
        customer.setAddress(raw.getAddressEntity().stream().map(addressMapper::map).toList());
        customer.setCard(raw.getCardEntity().stream().map(cardMapper::map).toList());

        return customer;
    }
}
