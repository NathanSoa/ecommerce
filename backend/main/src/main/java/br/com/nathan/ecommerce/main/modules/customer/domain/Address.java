package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.modules.customer.validator.AddressValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.addressValidator;

@Data
public class Address {
    private String alias;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private List<String> streetPurpose;

    @JsonIgnore
    private AddressValidator validator;

    private Address() {
        this.validator = addressValidator();
    }

    public static Address Create() {
        return new Address();
    }

    public Address withAlias(String alias) {
        validator.validateAlias(alias);
        this.alias = alias;
        return this;
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

    public Address withStreetPurpose(List<String> streetPurpose) {
        validator.validateStreetPurpose(streetPurpose);
        this.streetPurpose = streetPurpose;
        return this;
    }
}
