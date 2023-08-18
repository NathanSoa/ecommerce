package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.factory.Validators;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Email {

    private String value;

    public Email(String email) {
        final var emailValidator = Validators.emailValidator();
        emailValidator.validate(email);
        this.value = email;
    }
}
