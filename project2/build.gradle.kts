plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	id ("org.jetbrains.kotlin.plugin.noarg")
	kotlin("jvm")
	kotlin("plugin.spring")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("dev.miku:r2dbc-mysql")
	implementation("mysql:mysql-connector-java")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	implementation("com.squareup.okhttp3:okhttp:4.9.1")
	implementation("com.github.heremaps:oksse:0.9.0")
	implementation("com.google.code.gson:gson:2.8.7")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

configurations {
	all {
		exclude(group = "org.springframework.boot:spring-boot-starter-webflux", module = "spring-boot-starter-tomcat")
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

noArg {
	annotation("com.example.project2.config.Data")
}