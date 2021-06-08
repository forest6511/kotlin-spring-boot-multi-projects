# Self-Study Kotlin Spring Boot Multi projects 

## project1 
### Spring boot with Spring Web and Thymeleaf

### How to Run project1.

Command line
```
./gradlew :project1:bootRun
```

It's OK if The message 'Hello Project1' is Shown the url below.
```
http://localhost:8181/
```
#### TODO
- [ ] Implement Spring JPA

## project2 - TBD
### Spring boot with Flux and R2DB2

## common - TBD
### Shared project like Entity

- [ ] Check to work Entity AuditingEntityListener/CreatedBy annotation from R2DB2. Entity is to be generated by IDEA DataGrid.

## Flyway Directory - TBD
ref: https://qiita.com/kazzool/items/ab85d1f67813b9d438ff

## Devops Directory

Run
```
docker-compose up 
```

### Mysql

| env      | value                       | 
| -------- | --------------------------- | 
| port     | 3306                        | 
| user     | root                        | 
| password | password                    | 
| schemas  | example_dev<br>example_test | 

### Redis

| env      | value                       | 
| -------- | --------------------------- | 
| port     | 6379                        | 

### etc

```
docker system prune
rm -rf ./devops/mysql/data
rm -rf ./devops/redis/data
```


## Others

- [ ] Use GitHub Actions