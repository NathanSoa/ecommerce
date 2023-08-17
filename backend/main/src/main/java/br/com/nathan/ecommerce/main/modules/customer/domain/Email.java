package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Email {

    private String value;

    @Autowired
    private StringValidator<Email> emailValidator;

    public Email(String email) {
        this.validate(email);
        this.value = email;
    }

    private void validate(String email) {
        emailValidator.validate(email);
    }
}
