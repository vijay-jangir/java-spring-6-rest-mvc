package com.vijayjangir.spring6restmvc.controllers;

import com.vijayjangir.spring6restmvc.models.Beer;
import com.vijayjangir.spring6restmvc.services.BeerService;
import com.vijayjangir.spring6restmvc.services.BeerServiceImpl;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeer(){
        return beerService.listBeers();
    }

    @PostMapping
//    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<String> handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.addBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/vi/beer/"+savedBeer.id());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value= "{beerId}", method=RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID id) {
        log.debug("getBeerId - In Controller. Id: " + id.toString());
        return beerService.getBeerId(id);
    }
}
