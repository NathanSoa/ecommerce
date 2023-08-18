package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.factory.Validators;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CPF {

    private final String value;

    public CPF(String cpf) {
        final var cpfValidator = Validators.cpfValidator();
        cpfValidator.validate(cpf);
        this.value = cpf;
    }
}
