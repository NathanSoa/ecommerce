package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.useCases.PatchActiveUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@BaseController("/customers")
@AllArgsConstructor
public class DeactivateController {

    private final PatchActiveUseCase useCase;
    private final Mapper<Customer, CustomerPM> mapper;

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        var data = useCase.execute(id, false);
        return HttpHelper.ok(Optional.of(mapper.map(data)));
    }
}
