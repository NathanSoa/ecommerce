package br.com.nathan.ecommerce.main.modules.customer.controller.dto;

import br.com.nathan.ecommerce.main.modules.customer.domain.Address;

import java.util.List;

public record CustomerDTO(String name,
                          String email,
                          String password,
                          String cpf,
                          List<Address> address,
                          Boolean active) {
}
