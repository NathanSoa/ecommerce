package br.com.nathan.ecommerce.main.modules.customer.repository;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.annotation.CustomerCPF;
import br.com.nathan.ecommerce.main.modules.customer.repository.annotation.CustomerEmail;
import br.com.nathan.ecommerce.main.modules.customer.repository.annotation.CustomerName;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends BaseEntity {

    @CustomerName
    private String name;

    @CustomerEmail
    private String email;

    @CustomerCPF
    private String cpf;
}
