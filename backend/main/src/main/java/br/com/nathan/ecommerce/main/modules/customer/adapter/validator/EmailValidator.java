package br.com.nathan.ecommerce.main.modules.customer.adapter.validator;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Email;

public class EmailValidator implements StringValidator<Email> {

    @Override
    public void validate(String email) {
        if(email == null || email.isBlank() || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        var emailValidator = new org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator();
        if(!emailValidator.isValid(email, null)) {
            throw new IllegalArgumentException("Invalid email!");
        }
    }
}
