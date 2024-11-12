package no.ok.it.tcproblem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class TcproblemApplication

fun main(args: Array<String>) {
    runApplication<TcproblemApplication>(*args)
}
