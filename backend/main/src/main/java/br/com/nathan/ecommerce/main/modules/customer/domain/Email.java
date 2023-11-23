package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.emailValidator;

@Data
public class Email {

    private String value;

    public Email(String email) {
        emailValidator().validate(email);
        this.value = email;
    }
}
