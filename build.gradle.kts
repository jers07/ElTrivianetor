plugins {
    id("java")
}

group = "co.com.sofkaU"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.mysql:mysql-connector-j:8.2.0")
}

tasks.test {
    useJUnitPlatform()
}