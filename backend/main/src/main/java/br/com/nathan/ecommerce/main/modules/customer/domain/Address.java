package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.modules.customer.adapter.validator.AddressValidator;
import br.com.nathan.ecommerce.main.modules.customer.factory.Validators;
import lombok.Data;

@Data
public class Address {

    private static final AddressValidator validator = Validators.addressValidator();
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;

    private Address() { }

    public static Address Create() {
        return new Address();
    }

    public Address withStreet(String street) {
        validator.validateStreet(street);
        this.street = street;
        return this;
    }

    public Address withNumber(String number) {
        validator.validateNumber(number);
        this.number = number;
        return this;
    }

    public Address withComplement(String complement) {
        validator.validateComplement(complement);
        this.complement = complement;
        return this;
    }

    public Address withNeighborhood(String neighborhood) {
        validator.validateNeighborhood(neighborhood);
        this.neighborhood = neighborhood;
        return this;
    }

    public Address withCity(String city) {
        validator.validateCity(city);
        this.city = city;
        return this;
    }

    public Address withState(String state) {
        validator.validateState(state);
        this.state = state;
        return this;
    }

    public Address withZipCode(String zipCode) {
        validator.validateZipCode(zipCode);
        this.zipCode = zipCode;
        return this;
    }
}
