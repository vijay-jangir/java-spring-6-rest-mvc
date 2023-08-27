package com.vijayjangir.spring6restmvc.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Beer(UUID id, Integer version, String beerName, BeerStyle beerStyle, String upc, Integer quantityOnHand, BigDecimal price,
                   LocalDateTime createdDate, LocalDateTime updateDate) {
}
