package dev.dashaun.service.retailStore.controller;

import dev.dashaun.service.retailStore.domain.StoreJPA;
import dev.dashaun.service.retailStore.domain.StoreRedis;
import dev.dashaun.service.retailStore.repository.StoreJPARepository;
import dev.dashaun.service.retailStore.repository.StoreRedisRepository;
import dev.dashaun.service.retailStore.util.CSVLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RetailStoreController {
    private final StoreRedisRepository redisRepository;
    private final StoreJPARepository jpaRepository;
    private final CSVLoader csvLoader;
    
    public RetailStoreController(StoreRedisRepository redis,
                                 StoreJPARepository jpa,
    @Value("classpath:/Retail_Food_Stores.csv") Resource csv){
        this.redisRepository = redis;
        this.jpaRepository = jpa;
        csvLoader = new CSVLoader(csv);
    }

    @GetMapping("/load-redis")
    public void loadRedis(){
        csvLoader.redis(redisRepository);
    }

    @GetMapping("/load-jpa")
    public void loadJpa(){
        csvLoader.jpa(jpaRepository);
    }

    @GetMapping("/get-redis-by-id/{id}")
    public Optional<StoreRedis> redisById(@PathVariable String id){
        return redisRepository.findById(id);
    }

    @GetMapping("/get-jpa-by-id/{id}")
    public Optional<StoreJPA> jpaById(@PathVariable String id){
        return jpaRepository.findById(id);
    }
}