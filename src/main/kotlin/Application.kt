package com.tratzlaff.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


/**
 * Spring Boot looks for a public static main method.
 *
 * In Java, the main() method of a Spring Boot application is conventionally defined within
 * the annotated application class. This is because Java does NOT support top-level methods.
 * In Kotlin, however, we DO have top-level functions.
 *
 * In Kotlin, top-level functions are compiled into static members of an automatically-generated class.
 * The name of this class is derived from the name of the source file.
 * The top-level function defined in this file would be defined in a class named ApplicationKt.
 *
 * For the simplified Spring main entry point below to work, you must set the
 * springBoot.mainClass property in your build.gradle file to look for this main function.
 *
 * The other change needed for Spring Boot is to mark the class as open.
 * Spring boot @Configuration classes cannot be final.
 * Classes in Kotlin are final by default without the open modifier.
 */
@SpringBootApplication
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}


