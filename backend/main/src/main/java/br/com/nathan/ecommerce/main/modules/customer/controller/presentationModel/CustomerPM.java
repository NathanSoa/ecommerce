package br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel;

import br.com.nathan.ecommerce.main.modules.customer.domain.Address;

public record CustomerPM(Long id, String name, String cpf, String email, Address address, Boolean active) {
}
