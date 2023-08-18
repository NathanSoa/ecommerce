package br.com.nathan.ecommerce.main.modules.customer.repository.annotation;

import br.com.nathan.ecommerce.main.core.domain.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
@Size
@Pattern.List({
        @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain one upper letter."),
        @Pattern(regexp = "(?=.*[!@#$%^&*+=?-_()/\"\\.,<>~`;:]).+", message ="Password must contain one special character."),
})
public @interface Password {

    @AliasFor(annotation = Size.class, attribute = "min")
    int minLength() default Constants.PASSWORD_MIN_LENGTH;

    @AliasFor(annotation = Size.class, attribute = "max")
    int maxLength() default Constants.PASSWORD_MAX_LENGTH;
}
