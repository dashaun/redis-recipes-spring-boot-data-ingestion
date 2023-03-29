package dev.dashaun.service.retailStore.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.predicate.RuntimeHintsPredicates;

class MyRuntimeHintsTest {
    @Test
    void hints() {
        var hints = new RuntimeHints();
        var registrar = new MyRuntimeHints.MyRuntimeHintsRegistrar();
        var classloader = getClass().getClassLoader();
        registrar.registerHints(hints, classloader);
        Assertions.assertThat(RuntimeHintsPredicates.resource().forResource("Retail_Food_Stores.csv")).accepts(hints);
    }
}