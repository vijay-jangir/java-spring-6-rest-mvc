package com.vijayjangir.spring6restmvc.services;

import com.vijayjangir.spring6restmvc.models.Beer;
import com.vijayjangir.spring6restmvc.models.BeerStyle;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        beerMap = new HashMap<>();
        Beer beer1 = Beer.builder()
            .id(UUID.randomUUID())
            .beerStyle(BeerStyle.LAGER)
            .upc("1")
            .quantityOnHand(11)
            .createdDate(LocalDateTime.now())
            .beerName("Bud")
            .price(new BigDecimal(77))
            .updateDate(LocalDateTime.now())
            .version(1)
            .build();

        Beer beer2 = Beer.builder()
            .id(UUID.randomUUID())
            .beerStyle(BeerStyle.LAGER)
            .upc("2")
            .quantityOnHand(222)
            .createdDate(LocalDateTime.now())
            .beerName("Corona")
            .price(new BigDecimal(88))
            .updateDate(LocalDateTime.now())
            .version(1)
            .build();

        Beer beer3 = Beer.builder()
            .id(UUID.randomUUID())
            .beerStyle(BeerStyle.LAGER)
            .upc("3")
            .quantityOnHand(333)
            .createdDate(LocalDateTime.now())
            .beerName("Kingfisher")
            .price(new BigDecimal(99))
            .updateDate(LocalDateTime.now())
            .version(1)
            .build();

        this.beerMap.put(beer1.id(), beer1);
        this.beerMap.put(beer2.id(), beer2);
        this.beerMap.put(beer3.id(), beer3);

    }

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerId(UUID id) {
        log.debug("getBeerId - In Service. Id: " + id.toString());
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

    @Override
    public Beer addBeer(Beer beer) {
        log.debug("beer entry recieved:" + beer.toString());
        Beer addBeer = Beer.builder()
            .id(UUID.randomUUID())
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .version(1)
            .price(beer.price())
            .beerName(beer.beerName())
            .beerStyle(beer.beerStyle())
            .quantityOnHand(444)
            .upc(beer.upc())
            .build();

        beerMap.put(addBeer.id(), addBeer);
        return addBeer;
    }
}
