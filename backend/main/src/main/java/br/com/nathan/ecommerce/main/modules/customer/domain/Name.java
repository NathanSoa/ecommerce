package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.factory.Validators;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Name {

    private String value;

    public Name(String name) {
        final var nameValidator = Validators.nameValidator();
        nameValidator.validate(name);
        this.value = name;
    }
}
