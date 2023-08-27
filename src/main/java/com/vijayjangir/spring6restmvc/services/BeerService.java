package com.vijayjangir.spring6restmvc.services;

import com.vijayjangir.spring6restmvc.models.Beer;
import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerId(UUID id);

    Beer addBeer(Beer beer);

    void updateById(UUID id, Beer beer);

    void deleteById(UUID id);

    void updatePartialById(UUID id, Beer beer);
}
