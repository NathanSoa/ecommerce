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

    public CustomerEntity withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerEntity withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerEntity withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public CustomerEntity withPassword(String password) {
        this.password = password;
        return this;
    }

    public CustomerEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    public CustomerEntity withActive(Boolean active) {
        this.setActive(active);
        return this;
    }
}
