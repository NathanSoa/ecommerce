package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.nameValidator;

@Data
public class Name {

    private String value;

    public Name(String name) {
        nameValidator().validate(name);
        this.value = name;
    }
}
