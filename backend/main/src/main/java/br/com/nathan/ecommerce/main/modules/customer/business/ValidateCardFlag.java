package br.com.nathan.ecommerce.main.modules.customer.business;

import br.com.nathan.ecommerce.main.core.exceptions.BusinessException;
import br.com.nathan.ecommerce.main.core.interfaces.Strategy;
import br.com.nathan.ecommerce.main.modules.cardFlag.useCases.FindAllUseCase;
import br.com.nathan.ecommerce.main.modules.customer.domain.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ValidateCardFlag implements Strategy<List<Card>> {

    private final FindAllUseCase findAllFlags;

    @Override
    public void process(List<Card> object) {
        final var flags = findAllFlags.execute()
                .stream()
                .map(flag -> flag.getName().toUpperCase()).toList();

        object.forEach(card -> {
            if(!(flags.contains(card.getName().toUpperCase()))) {
                throw new BusinessException("card.flag.invalid");
            }
        });
    }
}
