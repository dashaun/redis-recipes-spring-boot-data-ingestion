package dev.dashaun.service.retailStore.domain;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@RedisHash
public class StoreRedis extends BaseStore {
    @Id
    private String License_Number;
}
