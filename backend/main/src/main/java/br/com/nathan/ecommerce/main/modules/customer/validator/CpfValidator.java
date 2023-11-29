package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;

public class CpfValidator implements Validator<String> {

    public static final String FORMATTED = "(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})";
    public static final String UNFORMATTED = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";

    @Override
    public void validate(String cpf) {
        if(cpf == null || cpf.isBlank() || cpf.isEmpty()) {
            throw new IllegalArgumentException("customer.cpf.required");
        }
        if (!(cpf.matches(FORMATTED) || cpf.matches(UNFORMATTED))) {
            throw new IllegalArgumentException("customer.cpf.invalid");
        }
    }
}
