import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

plugins {
    alias(libs.plugins.composeHotReload) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    id("org.jlleitschuh.gradle.ktlint") version "14.0.1"
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    detekt {
        buildUponDefaultConfig = true
        allRules = false
        config.setFrom(rootProject.file("config/detekt.yml"))
        // baseline = rootProject.file("config/baseline.xml")
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        verbose.set(true)
        outputToConsole.set(true)
        ignoreFailures.set(false)

        filter {
            exclude { it.file.path.contains("build/") }
            exclude { it.file.path.contains("generated/") }
        }
    }

    tasks.withType<Detekt>().configureEach {
        reports {
            html.required.set(true)
            sarif.required.set(true)
//            markdown.required.set(true)
        }
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = "21"
    }
    tasks.withType<DetektCreateBaselineTask>().configureEach {
        jvmTarget = "21"
    }
}
