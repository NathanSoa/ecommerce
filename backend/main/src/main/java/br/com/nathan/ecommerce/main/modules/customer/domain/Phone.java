package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.phoneValidator;

@Data
public class Phone {

    private String value;

    private Phone(String phone) {
        this.value = phone;
    }

    public static Phone withValidation(String phone) {
        phoneValidator().validate(phone);
        return new Phone(phone);
    }

    public static Phone withoutValidation(String phone) {
        return new Phone(phone);
    }
}
