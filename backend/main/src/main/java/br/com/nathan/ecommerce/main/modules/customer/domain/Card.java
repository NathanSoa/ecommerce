package br.com.nathan.ecommerce.main.modules.customer.domain;

import br.com.nathan.ecommerce.main.modules.customer.validator.CardValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import static br.com.nathan.ecommerce.main.modules.customer.factory.Validators.cardValidator;

@Data
public class Card {

    private String type;
    private String number;
    private String name;
    private String securityCode;
    private String flag;
    private Boolean main;

    @JsonIgnore
    private CardValidator validator;

    private Card() {
        this.validator = cardValidator();
    }

    public static Card Create() {
        return new Card();
    }

    public Card withType(String type) {
        validator.validateType(type);
        this.type = type;
        return this;
    }

    public Card withNumber(String number) {
        validator.validateNumber(number);
        this.number = number;
        return this;
    }

    public Card withName(String name) {
        validator.validateName(name);
        this.name = name;
        return this;
    }

    public Card withSecurityCode(String securityCode) {
        validator.validateSecurityCode(securityCode);
        this.securityCode = securityCode;
        return this;
    }

    public Card withFlag(String flag) {
        validator.validateFlag(flag);
        this.flag = flag;
        return this;
    }

    public Card withMain(Boolean main) {
        validator.validateMain(main);
        this.main = main;
        return this;
    }
}
