package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Name {

    private String value;

    @Autowired
    private StringValidator<Name> nameValidator;

    public Name(String name) {
        this.validate(name);
        this.value = name;
    }

    private void validate(String name) {
        nameValidator.validate(name);
    }
}
