package br.com.nathan.ecommerce.main.core.infra.messaging;

public interface MessagingConsumer<T> {

    void consume(T message);
}
