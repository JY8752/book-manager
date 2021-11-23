@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
//	id("com.arenagod.gradle.MybatisGenerator") version "1.4" //追加
	id("com.thinkimi.gradle.MybatisGenerator") version "2.3"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
}

group = "com.book.manager"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.mybatis.generator:mybatis-generator-core:1.4.0")//追加
	implementation("mysql:mysql-connector-java:8.0.23")//追加
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")//追加
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//追加 MyBatis Generator によるコード生成タスク
mybatisGenerator {
	verbose = true
	configFile = "${projectDir}/src/main/resources/generatorConfig.xml"

	dependencies {
		mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0")
	}
}
