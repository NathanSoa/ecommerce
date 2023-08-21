package br.com.nathan.ecommerce.main.modules.customer.adapter.mapper;

import br.com.nathan.ecommerce.main.core.mapper.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.repository.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityToAddress implements Mapper<AddressEntity, Address> {

    @Override
    public Address map(AddressEntity raw) {
        return Address.Create()
                    .withCity(raw.getCity())
                    .withComplement(raw.getComplement())
                    .withNeighborhood(raw.getNeighborhood())
                    .withNumber(raw.getNumber())
                    .withState(raw.getState())
                    .withStreet(raw.getStreet())
                    .withZipCode(raw.getZipCode());
    }
}
