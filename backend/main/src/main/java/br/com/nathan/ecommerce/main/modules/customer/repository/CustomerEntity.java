package br.com.nathan.ecommerce.main.modules.customer.repository;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.modules.customer.repository.annotation.CPF;
import br.com.nathan.ecommerce.main.modules.customer.repository.annotation.Email;
import br.com.nathan.ecommerce.main.modules.customer.repository.annotation.Name;
import br.com.nathan.ecommerce.main.modules.customer.repository.annotation.Password;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends BaseEntity {

    @Name
    private String name;

    @Email
    private String email;

    @CPF
    private String cpf;

    @Password
    private String password;
}
