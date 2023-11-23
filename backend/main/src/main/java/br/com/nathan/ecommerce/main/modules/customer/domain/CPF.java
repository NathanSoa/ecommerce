package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.cpfValidator;

@Data
public class CPF {

    private final String value;

    public CPF(String cpf) {
        cpfValidator().validate(cpf);
        this.value = cpf;
    }
}
