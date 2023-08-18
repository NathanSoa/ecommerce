package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.factory.Validators;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Password {

    private String value;

    public Password(String password) {
        final var passwordValidator = Validators.passwordValidator();
        passwordValidator.validate(password);
        this.value = password;
    }
}
