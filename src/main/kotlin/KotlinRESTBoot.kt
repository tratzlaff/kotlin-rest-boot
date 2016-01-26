package com.tratzlaff.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


// https://kotlinlang.org/docs/reference/data-classes.html
data class Greeting(val id: Long, val content: String)


/**
 * The GreetingController serves requests of the form /greeting?name={value}
 * and returns a JSON object representing an instance of Greeting.
 */
@RestController
class GreetingController {

    val counter = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }

}


/**
 * Spring Boot looks for a public static main method, so we define this in Kotlin using the @JvmStatic annotation.
 * For this, we create a standard Application class and define a companion object inside where we can then create a
 * function annotated with @JvmStatic.
 *
 * Note: JvmStatic is an annotation in Kotlin which is used for interoperability with Java,
 * so that the resulting method is defined as static when called from Java.
 *
 * The other change needed for Spring Boot is to mark the class as open.
 * Spring boot @Configuration classes cannot be final. Classes in Kotlin are final by default without the open modifier.
 */
@SpringBootApplication
open class Application {

    companion object {
        @JvmStatic public fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

}
