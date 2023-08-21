package br.com.nathan.ecommerce.main.modules.customer.controller.dto;

import br.com.nathan.ecommerce.main.modules.customer.domain.Address;

public record CustomerDTO(String name, String email, String password, String cpf, Address address, Boolean active) {
}
