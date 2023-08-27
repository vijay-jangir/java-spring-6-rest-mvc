package com.vijayjangir.spring6restmvc.controllers;

import com.vijayjangir.spring6restmvc.models.Beer;
import com.vijayjangir.spring6restmvc.services.BeerService;
import com.vijayjangir.spring6restmvc.services.BeerServiceImpl;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("api/v1/beer")
    public List<Beer> listBeer(){
        return beerService.listBeers();
    }
    public Beer getBeerById(UUID id) {
        log.debug("getBeerId - In Controller. Id: " + id.toString());
        return beerService.getBeerId(id);
    }
}
