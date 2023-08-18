package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Password {

    private String value;

    @Autowired
    private StringValidator<Password> passwordValidator;

    public Password(String password) {
        this.validate(password);
        this.value = password;
    }

    private void validate(String password) {
        passwordValidator.validate(password);
    }
}
