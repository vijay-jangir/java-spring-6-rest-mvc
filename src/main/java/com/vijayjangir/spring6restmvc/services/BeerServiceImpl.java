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
import org.springframework.util.StringUtils;

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

        this.beerMap.put(beer1.getId(), beer1);
        this.beerMap.put(beer2.getId(), beer2);
        this.beerMap.put(beer3.getId(), beer3);

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
            .price(beer.getPrice())
            .beerName(beer.getBeerName())
            .beerStyle(beer.getBeerStyle())
            .quantityOnHand(444)
            .upc(beer.getUpc())
            .build();

        beerMap.put(addBeer.getId(), addBeer);
        return addBeer;
    }

    @Override
    public void updateById(UUID id, Beer beer) {
        Beer existingBeer = beerMap.get(id);
        existingBeer.setBeerName(beer.getBeerName());
        existingBeer.setBeerStyle(beer.getBeerStyle());
        existingBeer.setUpc(beer.getUpc());
        existingBeer.setPrice(beer.getPrice());
        existingBeer.setUpdateDate(LocalDateTime.now());
        existingBeer.setVersion(existingBeer.getVersion()+1);
        existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
    }

    @Override
    public void deleteById(UUID id) {
        beerMap.remove(id);
    }

    @Override
    public void updatePartialById(UUID id, Beer beer) {
        // Only implementing name property, need to manually implement logic for all value udpates
        int change=0;
        Beer existingBeer = beerMap.get(id);
        if (StringUtils.hasText(beer.getBeerName())) {
            existingBeer.setBeerName(beer.getBeerName());
            change++;
        }
        if (change > 0) {
            existingBeer.setVersion(existingBeer.getVersion() + 1);
        }
    }
}
