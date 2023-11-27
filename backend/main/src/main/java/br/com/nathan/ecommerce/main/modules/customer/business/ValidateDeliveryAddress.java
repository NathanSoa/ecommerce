package br.com.nathan.ecommerce.main.modules.customer.business;

import br.com.nathan.ecommerce.main.core.exceptions.BusinessException;
import br.com.nathan.ecommerce.main.core.interfaces.Strategy;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidateDeliveryAddress implements Strategy<List<Address>> {

    @Override
    public void process(List<Address> object) {
        object.stream()
                .filter(
                        address -> address.getStreetPurpose().stream()
                                .map(String::toUpperCase)
                                .toList()
                                .contains("DELIVERY")
                )
                .findFirst()
                .orElseThrow(() -> new BusinessException("address.delivery"));
    }
}
