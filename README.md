# Self-Study Kotlin Spring Boot Multi projects 

## docker directory

Run
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
./gradlew :project1:bootRun
```

It's OK if The message 'Hello Project1' is Shown the url below.
```
http://localhost:8181/
```

#### TODO
- [x] Implement Spring JPA

## project2
### Spring boot with Flux and R2DB2

```
./gradlew :project2:bootRun
```

It's OK if The message 'Hello Project2' is Shown the url below.
```
http://localhost:8282/
```

## common directory
### Shared project like Entity

- [ ] Create entity and confirm it' works fine.


## Others

- [ ] Use GitHub Actions