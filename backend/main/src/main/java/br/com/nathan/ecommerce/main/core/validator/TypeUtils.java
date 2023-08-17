package br.com.nathan.ecommerce.main.core.validator;

public class TypeUtils {

    public static <T> boolean is(Object object, Class<T> clazz) {
        return object.getClass().getSimpleName().equals(clazz.getSimpleName());
    }
}
