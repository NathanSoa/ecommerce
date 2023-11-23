package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.config.constants.ValidationConstants;
import br.com.nathan.ecommerce.main.core.interfaces.Validator;

public class PasswordValidator implements Validator<String> {

    @Override
    public void validate(String object) {
        if (object == null || object.isBlank() || object.isEmpty()) {
            throw new IllegalArgumentException("customer.password.required");
        }
        if (object.length() < ValidationConstants.PASSWORD_MIN_LENGTH || object.length() > ValidationConstants.PASSWORD_MAX_LENGTH) {
            throw new IllegalArgumentException("customer.password.size");
        }
        if (!object.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("customer.password.uppercase");
        }
        if (!object.matches(".*[^a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("customer.password.special");
        }
    }
}
