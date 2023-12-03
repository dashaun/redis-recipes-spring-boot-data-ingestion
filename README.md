# Spring Data with JPA and Redis

Sets up Rest endpoints to load ~6mb CSV file.
Data is loaded 1 row at a time.
Data can be stored into either JPA(Postgres) or Redis
The Docker Compose file provides running instances of both Postgres & Redis

## Quick Start

```text
./mvnw clean package spring-boot:start -DskipTests
time http :8080/load-jpa
time http :8080/load-redis
./mvnw spring-boot:stop -Dspring-boot.stop.fork
```