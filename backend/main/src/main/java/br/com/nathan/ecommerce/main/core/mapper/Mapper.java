package br.com.nathan.ecommerce.main.core.mapper;

public interface Mapper<T, S> {

    S map(T raw);
}
