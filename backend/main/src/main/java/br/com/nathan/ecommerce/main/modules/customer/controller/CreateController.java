package br.com.nathan.ecommerce.main.modules.customer.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.core.infra.http.HttpHelper;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import br.com.nathan.ecommerce.main.modules.customer.controller.dto.CustomerDTO;
import br.com.nathan.ecommerce.main.modules.customer.controller.presentationModel.CustomerPM;
import br.com.nathan.ecommerce.main.modules.customer.domain.Customer;
import br.com.nathan.ecommerce.main.modules.customer.useCases.CreateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@BaseController("/customers")
@AllArgsConstructor
public class CreateController {

    private final CreateUseCase useCase;
    private final Mapper<CustomerDTO, Customer> dtoMapper;
    private final Mapper<Customer, CustomerPM> pmMapper;

    @PostMapping
    public ResponseEntity<?> handle(@RequestBody CustomerDTO dto) {
        var data = useCase.execute(dtoMapper.map(dto));
        return HttpHelper.ok(Optional.of(pmMapper.map(data)));
    }
}
