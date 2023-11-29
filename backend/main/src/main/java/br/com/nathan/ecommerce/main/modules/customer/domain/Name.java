package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.nameValidator;

@Data
public class Name {

    private String value;

    private Name(String name) {
        this.value = name;
    }

    public static Name withValidation(String name) {
        nameValidator().validate(name);
        return new Name(name);
    }

    public static Name withoutValidation(String name) {
        return new Name(name);
    }
}
