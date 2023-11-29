package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.core.utils.Utils.Hash256;
import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.passwordValidator;

@Data
public class Password {

    private String value;

    private Password(String password) {
        this.value = password;
    }

    public static Password withValidation(String password) {
        passwordValidator().validate(password);
        return new Password(Hash256(password));
    }

    public static Password withoutValidation(String password) {
        return new Password(password);
    }
}
