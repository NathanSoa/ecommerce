package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CPF {

    private final String value;

    @Autowired
    private StringValidator<CPF> cpfValidator;

    public CPF(String cpf) {
        this.validate(cpf);
        this.value = cpf;
    }

    private void validate(String cpf) {
        cpfValidator.validate(cpf);
    }
}
