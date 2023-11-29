package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.emailValidator;

@Data
public class Email {

    private String value;

    private Email(String email) {
        this.value = email;
    }

    public static Email withValidation(String email) {
        emailValidator().validate(email);
        return new Email(email);
    }

    public static Email withoutValidation(String email) {
        return new Email(email);
    }
}
