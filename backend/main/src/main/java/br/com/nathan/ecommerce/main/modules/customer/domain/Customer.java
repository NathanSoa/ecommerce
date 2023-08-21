package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private Name name;
    private Email email;
    private CPF cpf;
    private Password password;
    private Address address;
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

    public Customer withAddress(Address address) {
        if(address == null) throw new IllegalArgumentException("address.required");
        this.address = Address.Create()
                            .withCity(address.getCity())
                            .withComplement(address.getComplement())
                            .withNeighborhood(address.getNeighborhood())
                            .withNumber(address.getNumber())
                            .withState(address.getState())
                            .withStreet(address.getStreet())
                            .withZipCode(address.getZipCode());
        return this;
    }

    public Customer withActive(Boolean active) {
        this.active = active;
        return this;
    }
}
