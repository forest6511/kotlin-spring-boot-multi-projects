plugins {
	id("org.flywaydb.flyway") version "7.10.0"
	kotlin("jvm") version "1.5.10"
}

buildscript {
	dependencies {
		classpath("mysql:mysql-connector-java:8.0.23")
	}
}

repositories {
	mavenCentral()
}

task("dev", org.flywaydb.gradle.task.FlywayMigrateTask::class) {
	url = System.getenv("DB_URL") ?: "jdbc:mysql://localhost:3306/example_dev"
	user = System.getenv("DB_USER") ?: "root"
	password = System.getenv("DB_PASSWORD") ?: "password"
	baselineOnMigrate = true
	locations = arrayOf("filesystem:./sql")
}

