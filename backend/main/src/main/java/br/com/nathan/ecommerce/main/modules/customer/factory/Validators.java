package br.com.nathan.ecommerce.main.modules.customer.factory;

import br.com.nathan.ecommerce.main.core.validator.StringValidator;
import br.com.nathan.ecommerce.main.modules.customer.adapter.validator.*;
import br.com.nathan.ecommerce.main.modules.customer.domain.CPF;
import br.com.nathan.ecommerce.main.modules.customer.domain.Email;
import br.com.nathan.ecommerce.main.modules.customer.domain.Name;
import br.com.nathan.ecommerce.main.modules.customer.domain.Password;

public class Validators {

    public static StringValidator<Name> nameValidator() {
        return new NameValidator();
    }

    public static StringValidator<Password> passwordValidator() {
        return new PasswordValidator();
    }

    public static StringValidator<Email> emailValidator() {
        return new EmailValidator();
    }

    public static StringValidator<CPF> cpfValidator() {
        return new CPFValidator();
    }

    public static AddressValidator addressValidator() {
        return new AddressValidator();
    }
}
