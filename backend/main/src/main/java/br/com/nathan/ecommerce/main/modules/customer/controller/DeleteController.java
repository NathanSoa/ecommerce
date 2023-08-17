package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.exceptions.EntityNotFoundException;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.core.validator.TypeUtils;
import br.com.nathan.ecommerce.main.modules.customer.useCases.DeleteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@BaseController("/customer")
@AllArgsConstructor
public class DeleteController {

    private final DeleteUseCase deleteUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        try {
            deleteUseCase.execute(id);
            return HttpHelper.noContent();
        } catch (Exception exception) {
            if(TypeUtils.is(exception, EntityNotFoundException.class)) {
                return HttpHelper.badRequest(exception);
            }
            return HttpHelper.serverError(exception);
        }
    }
}
