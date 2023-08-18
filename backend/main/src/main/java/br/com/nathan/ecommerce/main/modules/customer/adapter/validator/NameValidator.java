package br.com.nathan.ecommerce.main.modules.customer.adapter.validator;

import br.com.nathan.ecommerce.main.core.domain.Constants;
import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Name;

public class NameValidator implements StringValidator<Name> {

    private static final int MAX_LENGTH = Constants.NAME_MAX_LENGTH;
    private static final int MIN_LENGTH = Constants.NAME_MIN_LENGTH;

    @Override
    public void validate(String name) {
        if(name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if(name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Name must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters");
        }
    }
}
