package br.com.nathan.ecommerce.main.modules.customer.repository;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class AddressEntity {

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zipCode;

    public AddressEntity withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressEntity withNumber(String number) {
        this.number = number;
        return this;
    }

    public AddressEntity withComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public AddressEntity withNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public AddressEntity withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressEntity withState(String state) {
        this.state = state;
        return this;
    }

    public AddressEntity withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
