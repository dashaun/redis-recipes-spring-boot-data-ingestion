# Spring Data with JPA and Redis

Sets up Rest endpoints to load ~6mb CSV file.
Data is loaded 1 row at a time.
Data can be store into either JPA(Postgres) or Redis
The Docker Compose file provides running instances of both Postgres & Redis

## Getting started with Docker Compose

```text
docker-compose up -d
./mvnw spring-boot:run
```