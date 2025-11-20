plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.eversadclown"
version = "0.0.1-SNAPSHOT"
description = "SpringReactiveServer"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc") //подключение к реактивной реляционной базе данных
    implementation("org.springframework.boot:spring-boot-starter-webflux") //для создания реактивных REST API
    implementation("org.springframework.boot:spring-boot-starter-validation") //для валидации входных данных REST API
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.6.0")

    runtimeOnly("org.postgresql:r2dbc-postgresql")


    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
