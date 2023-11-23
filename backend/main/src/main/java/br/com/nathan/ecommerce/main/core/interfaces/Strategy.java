package br.com.nathan.ecommerce.main.core.interfaces;

public interface Strategy<T> {

    void process(T object);
}
