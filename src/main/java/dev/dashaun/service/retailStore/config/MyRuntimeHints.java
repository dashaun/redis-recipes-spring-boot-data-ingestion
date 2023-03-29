package dev.dashaun.service.retailStore.config;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(MyRuntimeHints.MyRuntimeHintsRegistrar.class)
@Configuration
class MyRuntimeHints {

    static class MyRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            // Register resources
            hints.resources().registerPattern("Retail_Food_Stores.csv");
        }
    }
}
