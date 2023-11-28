package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.PatchPasswordRequest;
import br.com.nathan.ecommerce.main.modules.customer.useCases.PatchPasswordUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@BaseController("/customers")
@AllArgsConstructor
public class PatchPasswordController {

    private final PatchPasswordUseCase useCase;

    @PatchMapping("/{id}/password")
    public ResponseEntity<?> handle(@RequestBody PatchPasswordRequest request, @PathVariable Long id) {
        useCase.execute(id, request.password());
        return HttpHelper.noContent();
    }
}
