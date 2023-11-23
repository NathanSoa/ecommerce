package br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel;

import br.com.nathan.ecommerce.main.modules.customer.domain.Address;

import java.util.List;

public record CustomerPM(Long id,
                         String name,
                         String cpf,
                         String email,
                         List<Address> address,
                         Boolean active) {
}
