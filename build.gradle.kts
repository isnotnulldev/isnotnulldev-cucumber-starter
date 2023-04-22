plugins {
    java
}

dependencies {
    testImplementation("io.cucumber:cucumber-java:7.11.2")
    testImplementation("io.cucumber:cucumber-picocontainer:7.11.2") // added for DI
    testImplementation("io.cucumber:cucumber-junit:7.11.2") // added for assertions

}

repositories {
    mavenLocal()
    mavenCentral()
}

// add dependency for building the classpath
configurations {
    register("cucumberRuntime") {
        extendsFrom(testImplementation.get())
    }
}


tasks {
    val runTest by registering {
        doLast {
            runCucumber()
        }
        outputs.upToDateWhen{false} // turn off the local build-cache
    }

    val cucumberHelp by registering {
        doLast {
            runCucumber(true)
        }
    }
}


fun runCucumber(outputHelp: Boolean = false){
    javaexec {
        val main = "io.cucumber.core.cli.Main"
        val cucumberRuntime = configurations["cucumberRuntime"]
        val threads = Runtime.getRuntime().availableProcessors().div(2).toString() ?: "1"
        var cucumberArgs = mutableListOf("")
        mainClass.set(main)
        classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
        environment("CUCUMBER_PUBLISH_QUIET", true)
        //cucumberArgs.plusAssign(mutableListOf("--glue", "io.cucumber.skeleton", "src/test/resources"))
        if (outputHelp){
            args("--help")
        }
        else {
            cucumberArgs.plusAssign(mutableListOf("--threads", threads,
                    "--plugin", "html:target/cucumber-report.html",
                    "--plugin", "pretty"
            ))
            args(cucumberArgs)
        }
        // Set any System Properties
    }
}
