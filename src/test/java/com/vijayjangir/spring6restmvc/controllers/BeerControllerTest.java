package com.vijayjangir.spring6restmvc.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.vijayjangir.spring6restmvc.models.Beer;
import com.vijayjangir.spring6restmvc.models.BeerStyle;
import com.vijayjangir.spring6restmvc.services.BeerService;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerControllerTest {
    @Autowired
    BeerController beerController;

    @Test
    void getBeerId(){
        System.out.println(beerController.getBeerById(UUID.randomUUID()));
    }

    @Test
    void updatePartialById() {
        Beer beer1 = Beer.builder().id(UUID.randomUUID()).beerName("test1").beerStyle(BeerStyle.LAGER).build();
        Beer beer2 = Beer.builder().beerName("test2").build();
        final BeanWrapper src = new BeanWrapperImpl(beer2);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            System.out.println("pd = " + pd + " : " + pd.getName() + " : " + srcValue + " : " + pd.getPropertyType());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
//                if(pd.getPropertyType().isAnnotationPresent(Valid.class) || pd.getPropertyType().isAnnotationPresent(Data.class)) {
//                    System.out.println("PRESENT");
//                    getNullPropertyNames(pd, emptyNames);
//                }
            }
            String[] result = new String[emptyNames.size()];
            String [] emptyProperties =  emptyNames.toArray(result);
        BeanUtils.copyProperties(beer2, beer1, emptyProperties);
        System.out.println("BeanTest:" + beer1);

        System.out.println();
    }
}