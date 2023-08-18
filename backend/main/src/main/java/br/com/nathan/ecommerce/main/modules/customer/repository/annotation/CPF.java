package br.com.nathan.ecommerce.main.modules.customer.repository.annotation;


import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
@org.hibernate.validator.constraints.br.CPF
public @interface CPF {
}
