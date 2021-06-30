plugins {
	id("org.flywaydb.flyway")
	kotlin("jvm")
}

buildscript {
	dependencies {
		classpath("mysql:mysql-connector-java:8.0.23")
	}
}

task("migrateDev", org.flywaydb.gradle.task.FlywayMigrateTask::class) {
	url = System.getenv("DB_URL") ?: "jdbc:mysql://localhost:3306/example_dev"
	user = System.getenv("DB_USER") ?: "root"
	password = System.getenv("DB_PASSWORD") ?: "password"
	baselineOnMigrate = true
	locations = arrayOf("filesystem:./sql")
}

task("migrateTest", org.flywaydb.gradle.task.FlywayMigrateTask::class) {
	url = System.getenv("DB_URL") ?: "jdbc:mysql://localhost:3306/example_test"
	user = System.getenv("DB_USER") ?: "root"
	password = System.getenv("DB_PASSWORD") ?: "password"
	baselineOnMigrate = true
	locations = arrayOf("filesystem:./sql")
}

