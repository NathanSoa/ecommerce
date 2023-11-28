package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.phoneValidator;

@Data
public class Phone {

    private String value;

    public Phone(String phone) {
        phoneValidator().validate(phone);
        this.value = phone;
    }
}
