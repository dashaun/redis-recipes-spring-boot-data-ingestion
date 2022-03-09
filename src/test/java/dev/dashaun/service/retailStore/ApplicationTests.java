package dev.dashaun.service.retailStore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class ApplicationTests {

	@Container
	final static GenericContainer<?> redis;

	@Container
	static GenericContainer<?> postgres;

	static {
		redis = new GenericContainer<>(
				DockerImageName.parse("redis:latest"))
				.withExposedPorts(6379);
		postgres = new GenericContainer<>(
				DockerImageName.parse("postgres:latest"))
				.withExposedPorts(5432)
				.withEnv("POSTGRES_PASSWORD", "postgres");
	}

	@Test
	void contextLoads() {
	}

}