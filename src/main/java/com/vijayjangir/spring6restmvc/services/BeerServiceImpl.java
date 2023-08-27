package com.vijayjangir.spring6restmvc.services;

import com.vijayjangir.spring6restmvc.models.Beer;
import com.vijayjangir.spring6restmvc.models.BeerStyle;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerId(UUID id) {
        return Beer.builder()
            .id(id)
            .version(1)
            .beerName("Kingfisher")
            .beerStyle(BeerStyle.LAGER)
            .upc("1")
            .price(new BigDecimal(1234))
            .quantityOnHand(123)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();
    }
}
