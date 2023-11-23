package br.com.nathan.ecommerce.main.modules.customer.factory;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.validator.*;

public class Validators {

    private static final Validator<String> NAME_VALIDATOR = new NameValidator();
    private static final Validator<String> PASSWORD_VALIDATOR = new PasswordValidator();
    private static final Validator<String> EMAIL_VALIDATOR = new EmailValidator();
    private static final Validator<String> CPF_VALIDATOR = new CpfValidator();
    private static final AddressValidator ADDRESS_VALIDATOR = new AddressValidator();

    public static Validator<String> nameValidator() {
        return NAME_VALIDATOR;
    }

    public static Validator<String> passwordValidator() {
        return PASSWORD_VALIDATOR;
    }

    public static Validator<String> emailValidator() {
        return EMAIL_VALIDATOR;
    }

    public static Validator<String> cpfValidator() {
        return CPF_VALIDATOR;
    }

    public static AddressValidator addressValidator() {
        return ADDRESS_VALIDATOR;
    }
}