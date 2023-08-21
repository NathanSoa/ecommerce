package br.com.nathan.ecommerce.main.modules.customer.adapter.validator;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.domain.CPF;
public class CPFValidator implements StringValidator<CPF> {

    @Override
    public void validate(String cpf) {
        if(cpf == null || cpf.isBlank() || cpf.isEmpty()) {
            throw new IllegalArgumentException("customer.cpf.required");
        }
        var cpfValidator = new br.com.caelum.stella.validation.CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
        } catch (Exception e) {
            throw new IllegalArgumentException("customer.cpf.invalid");
        }
    }
}
