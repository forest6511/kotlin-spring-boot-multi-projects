# Self-Study Kotlin Spring Boot Multi projects 

## docker directory

run docker
```
docker-compose -f docker/main.yml up
```

| IMAGES | PORT | USER | PASSWD | SCHEMAS |
| - | - | - | - | - |
| mysql/mysql-server | 3306 | root | password | example_dev<br>example_test |
| redis:latest | 6379 | - | - | - |

### etc

```
docker system prune
rm -rf ./docker/mysql/data
rm -rf ./docker/redis/data
```
## migration directory

- development and testing evn
```
./gradlew :migration:migrateDev
./gradlew :migration:migrateTest
```

## project1 
### Spring boot with Spring Web and Thymeleaf

### How to Run project1.

```
./gradlew :project1:mbGenerator
```

```
./gradlew :project1:bootRun
```

It's OK if The message 'Hello Project1' is Shown the url below.
```
http://localhost:8181/
```

You can use graphiql the url below.
ref: https://github.com/graphql/graphiql
```
http://localhost:8181/graphiql
```

- [x] Implement Spring Mybatis
- [x] Implement graphql

ref:https://netflix.github.io/dgs/getting-started/

## project2
### Spring boot with Flux and R2DB2

```
./gradlew :project2:bootRun
```

It's OK if The message 'Hello Project2' is Shown the url below.
```
http://localhost:8282/
```

Redis put message
```
curl --location --request PUT 'http://localhost:8282/message/put/123' \
--header 'Content-Type: application/json' \
--data-raw ' {"message" : "test"}'
```

Redis SSE
```
curl http://localhost:8282/message/get/123
```
ref: https://github.com/spring-projects/spring-data-redis/blob/main/src/test/java/org/springframework/data/redis/stream/StreamReceiverIntegrationTests.java

- [ ] R2DBC
- [x] Redis Stream
- [x] SSE client

## Others

- [x] Use GitHub Actions