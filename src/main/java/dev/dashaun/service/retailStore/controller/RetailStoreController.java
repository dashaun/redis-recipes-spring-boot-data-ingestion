package dev.dashaun.service.retailStore.controller;

import dev.dashaun.service.retailStore.domain.StoreJPA;
import dev.dashaun.service.retailStore.domain.StoreRedis;
import dev.dashaun.service.retailStore.util.CSVLoader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RetailStoreController {
    private final CrudRepository<StoreRedis, String> redisRepository;
    private final CrudRepository<StoreJPA, String> jpaRepository;

    public RetailStoreController(CrudRepository<StoreRedis, String> redis,
                                 CrudRepository<StoreJPA, String> jpa){
        this.redisRepository = redis;
        this.jpaRepository = jpa;
    }

    @GetMapping("/load-redis")
    public void loadRedis(){
        CSVLoader.redis(redisRepository);
    }

    @GetMapping("/load-jpa")
    public void loadJpa(){
        CSVLoader.jpa(jpaRepository);
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