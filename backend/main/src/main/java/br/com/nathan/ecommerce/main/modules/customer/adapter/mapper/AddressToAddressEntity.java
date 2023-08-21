package br.com.nathan.ecommerce.main.modules.customer.adapter.mapper;

import br.com.nathan.ecommerce.main.core.mapper.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.repository.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressEntity implements Mapper<Address, AddressEntity> {

    @Override
    public AddressEntity map(Address raw) {
        return new AddressEntity()
                .withCity(raw.getCity())
                .withComplement(raw.getComplement())
                .withNeighborhood(raw.getNeighborhood())
                .withNumber(raw.getNumber())
                .withState(raw.getState())
                .withStreet(raw.getStreet())
                .withZipCode(raw.getZipCode());
    }
}
