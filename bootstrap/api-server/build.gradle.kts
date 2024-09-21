plugins {
    idea
}

tasks.bootJar {
    enabled = true
}

tasks.jar {
    enabled = false
}

dependencies {
    implementation(project(":domain:user"))
    implementation(project(":domain:authentication"))
    implementation(project(":domain:location"))
}
