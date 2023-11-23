package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.useCases.FindOneUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@AllArgsConstructor
@BaseController("/customers")
public class FindOneController {

    private final FindOneUseCase findOneUseCase;
    private final Mapper<Customer, CustomerPM> mapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        final var data = mapper.map(findOneUseCase.execute(id));
        return HttpHelper.ok(Optional.of(data));
    }
}
