package com.vijayjangir.spring6restmvc.services;

import com.vijayjangir.spring6restmvc.models.Beer;
import java.util.UUID;

public interface BeerService {
    Beer getBeerId(UUID id);
}
