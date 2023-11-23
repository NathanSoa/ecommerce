package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;

public class EmailValidator implements Validator<String> {

    @Override
    public void validate(String email) {
        if(email == null || email.isBlank() || email.isEmpty()) {
            throw new IllegalArgumentException("customer.email.required");
        }
        var emailValidator = new org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator();
        if(!emailValidator.isValid(email, null)) {
            throw new IllegalArgumentException("customer.email.invalid");
        }
    }
}
