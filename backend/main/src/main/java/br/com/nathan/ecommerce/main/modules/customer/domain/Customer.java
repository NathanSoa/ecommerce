package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private Name name;
    private Email email;
    private CPF cpf;

    private Customer() { }

    public static Customer New() {
        return new Customer();
    }

    private Customer withId(Long id) {
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
}
