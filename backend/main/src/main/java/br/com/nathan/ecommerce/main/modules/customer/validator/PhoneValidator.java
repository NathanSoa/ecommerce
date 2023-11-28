package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;

public class PhoneValidator implements Validator<String> {

    @Override
    public void validate(String object) {
        if(object == null || object.isBlank() || object.isEmpty()) {
            throw new IllegalArgumentException("customer.phone.required");
        }

        String regex = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$";
        if(!object.matches(regex)) {
            throw new IllegalArgumentException("customer.phone.invalid");
        }
    }
}
