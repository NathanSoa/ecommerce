package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerDTO;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.useCases.UpdateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@BaseController("/customers")
@AllArgsConstructor
public class UpdateController {

    private final UpdateUseCase useCase;
    private final Mapper<CustomerDTO, Customer> dtoMapper;
    private final Mapper<Customer, CustomerPM> pmMapper;

    @PutMapping("/{id}")
    public ResponseEntity<?> handle(@RequestBody CustomerDTO dto, @PathVariable Long id) {
        var data = useCase.execute(dtoMapper.map(dto), id);
        return HttpHelper.ok(Optional.of(pmMapper.map(data)));
    }
}
