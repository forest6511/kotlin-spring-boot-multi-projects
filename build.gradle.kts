import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// apply false means that parent project is not applied
plugins {
	id("org.flywaydb.flyway") version "7.10.0"
	id("org.springframework.boot") version "2.5.1" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	kotlin("jvm") version "1.5.10" apply false
	kotlin("plugin.spring") version "1.5.10" apply false
}

allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<JavaCompile> {
		sourceCompatibility = "11"
		targetCompatibility = "11"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}
}

subprojects {
	repositories {
		mavenCentral()
	}
}