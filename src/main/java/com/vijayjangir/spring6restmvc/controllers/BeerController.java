package com.vijayjangir.spring6restmvc.controllers;

import com.vijayjangir.spring6restmvc.models.Beer;
import com.vijayjangir.spring6restmvc.services.BeerService;
import com.vijayjangir.spring6restmvc.services.BeerServiceImpl;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {
        log.debug("getBeerId - In Controller. Id: " + id.toString());
        return beerService.getBeerId(id);
    }
}
