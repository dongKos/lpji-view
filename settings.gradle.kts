plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "lpjiview"

include("bootstrap:api-server")
include("common:core")

include("domain:user")
include("domain:authentication")
include("domain:location")
