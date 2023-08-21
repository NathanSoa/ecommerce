package br.com.nathan.ecommerce.main.core.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@AllArgsConstructor
public class MessageResolver {

    private final MessageSource messageSource;

    public String resolve(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }
}