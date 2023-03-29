package dev.dashaun.service.retailStore.domain;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class StoreJPA extends BaseStore{
    @Id
    private String License_Number;

    public StoreJPA() {

    }
}
