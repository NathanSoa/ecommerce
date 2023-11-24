package br.com.nathan.ecommerce.main.modules.customer.validator;

import br.com.nathan.ecommerce.main.core.interfaces.Validator;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;

public class CardValidator implements Validator<Card> {

    @Override
    public void validate(Card object) {

    }

    public void validateType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("card.type");
        }
    }

    public void validateNumber(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("card.number");
        }
    }

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("card.name");
        }
    }

    public void validateSecurityCode(String securityCode) {
        if (securityCode == null || securityCode.isEmpty()) {
            throw new IllegalArgumentException("card.securityCode");
        }
    }

    public void validateFlag(String flag) {
        if (flag == null || flag.isEmpty()) {
            throw new IllegalArgumentException("card.flag");
        }
    }

    public void validateMain(Boolean main) {
        if (main == null) {
            throw new IllegalArgumentException("card.main");
        }
    }
}
