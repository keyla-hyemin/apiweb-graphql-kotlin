import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val springBootPluginVersion = "2.1.9.RELEASE"
    val kotlinVersion = "1.3.50"

    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false

    id("org.springframework.boot") version springBootPluginVersion
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
}

group = "bhm"
version = "1.0-SNAPSHOT"

repositories {
    maven("http://repo.ncsoft.net/artifactory/libs-release")
    maven("http://repo.ncsoft.net/artifactory/libs-snapshot")
    maven("http://repo.ncsoft.net/artifactory/service-snapshot-release")
    maven("http://repo.ncsoft.net/artifactory/service-snapshot-local")
    mavenLocal()
//    mavenCentral()
}

//springBoot {
//    buildInfo {
//        properties {
//            var envBuildNumber = System.getenv("BUILD_NUMBER")
//            if ( envBuildNumber.isNullOrEmpty() ) {
//                envBuildNumber = "LOCAL_BUILD"
//            }
//
//            additional = mapOf(
//                    "java.source" to "${project.java.sourceCompatibility}",
//                    "java.target" to "${project.java.targetCompatibility}",
//                    "build.number" to envBuildNumber
//            )
//        }
//    }
//    mainClassName = "com.account.admin.web.Application"
//}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("com.graphql-java:graphiql-spring-boot-starter:5.0.2")
//    implementation("com.graphql-java:graphql-spring-boot-starter:5.0.2")
//    implementation("com.graphql-java:voyager-spring-boot-starter:5.0.2")
//    implementation("com.graphql-java:graphql-java-tools:5.2.4")
    // ... rest of dependencies

    implementation("com.expediagroup:graphql-kotlin-spring-server:3.6.0")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework:spring-webflux")
    implementation("io.projectreactor:reactor-core")

}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {



}