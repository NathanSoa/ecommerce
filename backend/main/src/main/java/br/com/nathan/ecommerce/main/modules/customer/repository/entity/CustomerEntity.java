package br.com.nathan.ecommerce.main.modules.customer.repository.entity;

import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.config.constants.ValidationConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends BaseEntity {

    @NotBlank(message = "{customer.name.not-blank}")
    @Size(min = ValidationConstants.NAME_MIN_LENGTH, max = ValidationConstants.NAME_MAX_LENGTH, message = "{customer.name.size}")
    private String name;

    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    private String cpf;

    @Pattern.List({
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain one upper letter."),
            @Pattern(regexp = "(?=.*[!@#$%^&*+=?-_()/\"\\.,<>~`;:]).+", message ="Password must contain one special character."),
    })
    @NotBlank
    @Size(min = ValidationConstants.PASSWORD_MIN_LENGTH, max = ValidationConstants.PASSWORD_MAX_LENGTH)
    private String password;

    @OneToMany(mappedBy = "customerEntity")
    private List<AddressEntity> addressEntity;

    @OneToMany(mappedBy = "customerEntity")
    private List<CardEntity> cardEntity;


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

    public CustomerEntity withAddress(List<AddressEntity> addressEntity) {
        if(addressEntity == null || addressEntity.isEmpty()) throw new IllegalArgumentException("address.required");
        this.addressEntity = addressEntity;
        return this;
    }

    public CustomerEntity withCard(List<CardEntity> cardEntity) {
        if(cardEntity == null || cardEntity.isEmpty()) throw new IllegalArgumentException("card.required");
        this.cardEntity = cardEntity;
        return this;
    }
}
