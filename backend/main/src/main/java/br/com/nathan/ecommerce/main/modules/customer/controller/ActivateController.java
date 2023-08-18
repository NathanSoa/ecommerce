package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.core.validator.TypeUtils;
import br.com.nathan.ecommerce.main.modules.customer.useCases.PatchActiveUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@BaseController("/customers")
@AllArgsConstructor
public class ActivateController {

    private final PatchActiveUseCase useCase;

    @PutMapping("/{id}/activate")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        try {
            var data = useCase.execute(id, true);
            return HttpHelper.ok(Optional.of(data));
        } catch (Exception exception) {
            if(TypeUtils.is(exception, EntityNotFoundException.class)) {
                return HttpHelper.badRequest(exception);
            }
            return HttpHelper.serverError(exception);
        }
    }
}
