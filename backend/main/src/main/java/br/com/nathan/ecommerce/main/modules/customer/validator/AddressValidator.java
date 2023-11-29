package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Address;
import br.com.nathan.ecommerce.main.modules.customer.domain.AddressPurpose;

import java.util.List;

public class AddressValidator implements Validator<Address> {

    @Override
    public void validate(Address object) {
        validateAlias(object.getAlias());
        validateStreet(object.getStreet());
        validateNumber(object.getNumber());
        validateNeighborhood(object.getNeighborhood());
        validateCity(object.getCity());
        validateState(object.getState());
        validateZipCode(object.getZipCode());
    }

    public void validateAlias(String alias) {
        if (alias == null || alias.isEmpty()) {
            throw new IllegalArgumentException("address.alias");
        }
    }

    public void validateStreet(String street) {
        if (street == null || street.isEmpty()) {
            throw new IllegalArgumentException("address.street");
        }
    }

    public void validateNumber(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("address.number");
        }
    }

    public void validateNeighborhood(String neighborhood) {
        if (neighborhood == null || neighborhood.isEmpty()) {
            throw new IllegalArgumentException("address.neighborhood");
        }
    }

    public void validateCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("address.city");
        }
    }

    public void validateState(String state) {
        if (state == null || state.isEmpty()) {
            throw new IllegalArgumentException("address.state");
        }
    }

    public void validateZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty()) {
            throw new IllegalArgumentException("address.zipcode.required");
        }
        if (!zipCode.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("address.zipcode.format");
        }
    }

    public void validateStreetPurpose(List<String> streetPurpose) {
        streetPurpose.forEach(each -> {
            if (each == null || each.isEmpty()) {
                throw new IllegalArgumentException("address.streetPurpose.required");
            }

            if(!each.equals(AddressPurpose.BILLING.getDescription()) && !each.equals(AddressPurpose.DELIVERY.getDescription())) {
                throw new IllegalArgumentException("address.streetPurpose.invalid");
            }
        });
    }
}
