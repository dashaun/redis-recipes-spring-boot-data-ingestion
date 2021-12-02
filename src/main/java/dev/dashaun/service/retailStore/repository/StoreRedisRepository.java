package dev.dashaun.service.retailStore.repository;

import dev.dashaun.service.retailStore.domain.StoreRedis;
import org.springframework.data.repository.CrudRepository;

public interface StoreRedisRepository extends CrudRepository<StoreRedis, String> {
}
