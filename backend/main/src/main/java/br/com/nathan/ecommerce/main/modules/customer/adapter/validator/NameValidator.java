package br.com.nathan.ecommerce.main.modules.customer.adapter.validator;

import br.com.nathan.ecommerce.main.config.constants.ValidationConstants;
import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Name;

public class NameValidator implements StringValidator<Name> {

    private static final int MAX_LENGTH = ValidationConstants.NAME_MAX_LENGTH;
    private static final int MIN_LENGTH = ValidationConstants.NAME_MIN_LENGTH;

    @Override
    public void validate(String name) {
        if(name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("customer.name.required");
        }

        if(name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("customer.name.size");
        }
    }
}
