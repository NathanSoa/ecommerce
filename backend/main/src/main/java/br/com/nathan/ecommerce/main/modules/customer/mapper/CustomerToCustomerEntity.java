package br.com.nathan.ecommerce.main.modules.customer.mapper;

import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CardEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.nathan.ecommerce.main.core.utils.Utils.TrueIfNull;

@Component
@AllArgsConstructor
public class CustomerToCustomerEntity implements Mapper<Customer, CustomerEntity> {

    private final Mapper<Address, AddressEntity> addressMapper;
    private final Mapper<Card, CardEntity> cardMapper;

    @Override
    public CustomerEntity map(Customer raw) {
        return  new CustomerEntity()
                    .withId(raw.getId())
                    .withName(raw.getName().getValue())
                    .withEmail(raw.getEmail().getValue())
                    .withCpf(raw.getCpf().getValue())
                    .withPhone(raw.getPhone().getValue())
                    .withPassword(raw.getPassword().getValue())
                    .withAddress(raw.getAddress().stream().map(addressMapper::map).toList())
                    .withCard(raw.getCard().stream().map(cardMapper::map).toList())
                    .withActive(TrueIfNull(raw.getActive()));

    }
}
