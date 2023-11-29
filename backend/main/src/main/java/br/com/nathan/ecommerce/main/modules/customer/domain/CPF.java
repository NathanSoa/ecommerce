package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.cpfValidator;

@Data
public class CPF {

    private final String value;

    private CPF(String cpf) {
        this.value = cpf;
    }

    public static CPF withValidation(String cpf) {
        cpfValidator().validate(cpf);
        return new CPF(cpf);
    }

    public static CPF withoutValidation(String cpf) {
        return new CPF(cpf);
    }
}
