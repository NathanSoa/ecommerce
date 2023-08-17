package br.com.nathan.ecommerce.main.modules.customer.repository.annotation;

import br.com.nathan.ecommerce.main.core.domain.Constants;
import jakarta.validation.constraints.NotBlank;
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
public @interface CustomerName {

    @AliasFor(annotation = Size.class, attribute = "min")
    int minLength() default Constants.NAME_MIN_LENGTH;

    @AliasFor(annotation = Size.class, attribute = "max")
    int maxLength() default Constants.NAME_MAX_LENGTH;
}
