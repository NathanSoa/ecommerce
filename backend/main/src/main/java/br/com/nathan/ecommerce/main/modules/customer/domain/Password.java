package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.passwordValidator;

@Data
public class Password {

    private String value;

    public Password(String password) {
        passwordValidator().validate(password);
        this.value = password;
    }
}
