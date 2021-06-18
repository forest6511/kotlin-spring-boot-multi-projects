plugins {
    id("com.thinkimi.gradle.MybatisGenerator")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id ("org.jetbrains.kotlin.plugin.noarg")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    // if implementation of another sub module
    //implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
    implementation("com.zaxxer:HikariCP")
    implementation("mysql:mysql-connector-java")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

mybatisGenerator {
    verbose = true
    configFile = "${projectDir}/generatorConfig.xml"

    dependencies {
        mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0")
        // It dose not need to put the classpath location in generatorConfig.xml if declare it here.
        mybatisGenerator("mysql:mysql-connector-java")
    }
}

noArg {
    annotation("com.example.project1.Data")
}