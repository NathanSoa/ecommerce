package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.core.mapper.Mapper;
import br.com.nathan.ecommerce.main.core.validator.TypeUtils;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.useCases.FindOneUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@AllArgsConstructor
@BaseController("/customer")
public class FindOneController {

    private final FindOneUseCase findOneUseCase;
    private final Mapper<Customer, CustomerPM> mapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        try {
            final var data = mapper.map(findOneUseCase.execute(id));
            return HttpHelper.ok(Optional.of(data));
        } catch (Exception exception) {
            if(TypeUtils.is(exception, EntityNotFoundException.class)) {
                return HttpHelper.notFound(exception);
            }
            return HttpHelper.serverError(exception);
        }
    }
}
