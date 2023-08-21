package br.com.nathan.ecommerce.main.modules.customer.adapter.validator;

public class AddressValidator {

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

    public void validateComplement(String complement) {
        if (complement == null || complement.isEmpty()) {
            throw new IllegalArgumentException("address.complement");
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
}
