package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Long id;
    private Name name;
    private Email email;
    private CPF cpf;
    private Password password;
    private List<Address> address;
    private Boolean active;

    private Customer() { }

    public static Customer Create() {
        return new Customer();
    }

    public Customer withId(Long id) {
        this.id = id;
        return this;
    }

    public Customer withName(String name) {
        this.name = new Name(name);
        return this;
    }

    public Customer withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Customer withCPF(String cpf) {
        this.cpf = new CPF(cpf);
        return this;
    }

    public Customer withPassword(String password) {
        this.password = new Password(password);
        return this;
    }

    public Customer withAddress(List<Address> address) {
        if(address == null || address.isEmpty()) throw new IllegalArgumentException("address.required");
        this.address = address.stream()
                .map(a -> Address.Create()
                        .withCity(a.getCity())
                        .withComplement(a.getComplement())
                        .withNeighborhood(a.getNeighborhood())
                        .withNumber(a.getNumber())
                        .withState(a.getState())
                        .withStreet(a.getStreet())
                        .withZipCode(a.getZipCode()))
                .toList();
        return this;
    }

    public Customer withActive(Boolean active) {
        this.active = active;
        return this;
    }
}
