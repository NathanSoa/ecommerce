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

@BaseController("/customers")
@AllArgsConstructor
public class DeactivateController {

    private final PatchActiveUseCase useCase;

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        try {
            useCase.execute(id, false);
            return HttpHelper.noContent();
        } catch (Exception exception) {
            if(TypeUtils.is(exception, EntityNotFoundException.class)) {
                return HttpHelper.badRequest(exception);
            }
            return HttpHelper.serverError(exception);
        }
    }
}