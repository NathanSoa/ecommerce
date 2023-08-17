package br.com.nathan.ecommerce.main.core.infra.messaging;

public interface MessagingProducer<T> {

    void send(T message);
}
